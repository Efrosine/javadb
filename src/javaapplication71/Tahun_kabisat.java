/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package javaapplication71;

import java.util.Scanner;

public class Tahun_kabisat {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Plih menu (1/2)");
        int menu = reader.nextInt();
        switch(menu){
            case 1:
                System.out.println("Masukan tahun awal");
                int awalTahun = reader.nextInt();
                System.out.println("Masukan tahun akhir");
                int akhirTahun = reader.nextInt();
                for(int i = awalTahun;i<= akhirTahun;i++){CheckKabisat(i);}
                break;
            case 2:
                System.out.println("Keluar");
                break;
                default:
                    System.out.println("Angka yang kamu masukkan salah !!! Pilih 1/2");
        }
    }

    private static void CheckKabisat(int i) {
       
         if(i%4!=0) {System.out.println("Tahun "+i+" bukan tahun kabisat");
         return;}
         if(i%100!=0){ System.out.println("Tahun "+i+" adalah tahun kabisat");
         return;}
         if(i%400==0){
             System.out.println("Tahun "+i+" adalah tahun kabisat");
             return;
         }
         {System.out.println("Tahun "+i+" bukan tahun kabisat");
        }
    }

    }
