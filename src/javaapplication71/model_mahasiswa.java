/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication71;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class model_mahasiswa {

    String jdbcDriver = "com.mysql.jdbc.Driver";
    String dbUrl = "jdbc:mysql://localhost/lembar_penilaian";
    String user = "root";
    String password = "";

    Connection con;
    Statement st;
    ResultSet rs;
    PreparedStatement ps;

    boolean respons;

    public model_mahasiswa() {
        try {
            Class.forName(jdbcDriver);
            System.out.println("Driver Load");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver Tidak Ditemukan");
            Logger.getLogger(model_mahasiswa.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con = DriverManager.getConnection(dbUrl, user, password);
            System.out.println("Berhasil Terkoneksi");
        } catch (SQLException ex) {
            Logger.getLogger(model_mahasiswa.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Koneksi");
        }
    }

    public boolean simpanData(String nim, String nama, String kelas, String matkul) {
        String quary = "insert into fajartri_220605110152 (nim, nama, kelas, matkul) value (?,?,?,?)";
        try {
            ps = con.prepareStatement(quary);
            ps.setString(1, nim);
            ps.setString(2, nama);
            ps.setString(3, kelas);
            ps.setString(4, matkul);
            ps.executeUpdate();
            respons = true;
            System.out.println("Data berhasil disimpan");

        } catch (SQLException ex) {
            Logger.getLogger(model_mahasiswa.class.getName()).log(Level.SEVERE, null, ex);
            respons = false;
            System.out.println("Data gagal disimpan");
        }
        return respons;
    }

    public boolean editData(String nim, String nama, String kelas, String matkul) {
        String quary = "update fajartri_220605110152 set nim = ?,nama = ?,kelas = ?,matkul = ? where nim = ?";
        try {
            ps = con.prepareStatement(quary);
            ps.setString(1, nim);
            ps.setString(2, nama);
            ps.setString(3, kelas);
            ps.setString(4, matkul);
            ps.setString(5, nim);
            ps.executeUpdate();
            respons = true;
            System.out.println("Data berhasil diedit");

        } catch (SQLException ex) {
            Logger.getLogger(model_mahasiswa.class.getName()).log(Level.SEVERE, null, ex);
            respons = false;
            System.out.println("Data gagal diedit");
        }
        return respons;
    }

    public void hapusData(String nim) {
        String quary = "delete from fajartri_220605110152 where nim= ?";
        try {
            ps = con.prepareStatement(quary);
            ps.setString(1, nim);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(model_mahasiswa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet cariData(String nim) {
        String quary = "select * from fajartri_220605110152 where nim=" + nim;
        try {
            st = con.createStatement();
            rs = st.executeQuery(quary);
        } catch (SQLException ex) {
            Logger.getLogger(model_mahasiswa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;

    }
}
