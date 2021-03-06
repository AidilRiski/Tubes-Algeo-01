import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.*;
import java.text.DecimalFormat;
import java.math.RoundingMode;
import java.lang.*;

class TugasBesarAlgeo{

  public static final int ExitInput = -999;
  
    public static void TulisMenu () {
      System.out.println ("#=================================================#");
      System.out.println ("# METODE PENYELESAIAN                             #");
      System.out.println ("#-------------------------------------------------#");
      System.out.println ("# Silakan pilih salah satu metode dibawah berikut!#");
      System.out.println ("#=================================================#");
      System.out.println ("# 1. Eliminasi Gauss                              #");
      System.out.println ("# 2. Eliminasi Gauss-Jordan                       #");
      System.out.println ("# 3. Kembali ke awal program                      #");
      System.out.println ("#=================================================#");
      System.out.print ("  Ketik '1' atau '2' atau '3' pada keyboard: ");
    }

    public static void TulisMenuBaca () {
      System.out.println ("#=================================================#");
      System.out.println ("# PEMBACAAN MATRIKS                               #");
      System.out.println ("#-------------------------------------------------#");
      System.out.println ("# Silakan pilih salah pilihan dibawah berikut!    #");
      System.out.println ("#=================================================#");
      System.out.println ("# 1. Baca dari keyboard                           #");
      System.out.println ("# 2. Baca dari file                               #");
      System.out.println ("# 3. Kembali ke awal program                      #");
      System.out.println ("#=================================================#");
      System.out.print ("  Ketik '1' atau '2' atau '3' pada keyboard: ");
    }

  /*  public static void MenuMatriksEselon () {
      System.out.print ("Masukkan jumlah baris efektif: ");
      Brs = masuk.nextInt();
      System.out.print ("Masukkan jumlah kolom efektif: ");
      Kol = masuk.nextInt();
      M1.MakeEmpty(Brs,Kol);
      System.out.println ("Masukkan elemen matriks:");
      M1.BacaMatriks(Brs,Kol);
      Gauss G1 = new Gauss(M1);
      G1.CreateEchelon();
      System.out.println ("Matriks eselon: ");
      G1.matriks.TulisMatriks();
    } */

    public static void main(String[] args)throws Exception {
      String namafile = new String();
      int menumunculpertama, menumunculkedua, menumunculketiga;
      int Brs, Kol;
      FileEksternal f = new FileEksternal();
      Matriks M1 = new Matriks (1,1);
      /*System.out.println ("Masukkan nama FileEksternal dengan format .txt (tulis .txt juga)");
      System.out.println ("(Contoh : aingcupu.txt)");
      System.out.print ("Nama file : ");
      Scanner sc = new Scanner(System.in);
      namafile = sc.nextLine();
      f.AssignNamaFile(namafile);
      f.BacaMatriksFileSPL(M1, namafile);
      */

      Scanner masuk = new Scanner (System.in);
      menumunculpertama = 0;

      while (menumunculpertama != 3){
        System.out.println ("#=================================================#");
        System.out.println ("# SELAMAT DATANG DI TUGAS BESAR ALJABAR GEOMETRI! #");
        System.out.println ("#-------------------------------------------------#");
        System.out.println ("# Aidil Rezjki Suljztan Syawaludin - 13517070     #");
        System.out.println ("# Edward Alexander Jaya            - 13517115     #");
        System.out.println ("# Mohammad Ridwan Hady Arifin      - 13517007     #");
        System.out.println ("#=================================================#");
        System.out.println ();

        //Menu Utama
        System.out.println ("#=================================================#");
        System.out.println ("# MENU UTAMA                                      #");
        System.out.println ("#-------------------------------------------------#");
        System.out.println ("# Silakan pilih salah satu menu dibawah berikut!  #");
        System.out.println ("#=================================================#");
        System.out.println ("# 1. Sistem Persamaan Linier                      #");
        System.out.println ("# 2. Interpolasi Polinom                          #");
        System.out.println ("# 3. Keluar Program                               #");
        System.out.println ("#=================================================#");
        System.out.print ("  Ketik '1' atau '2' atau '3' pada keyboard: ");

        menumunculpertama = masuk.nextInt();

        while ((menumunculpertama != 1 ) && (menumunculpertama != 2) && (menumunculpertama != 3)) {
          System.out.print ("  Silakan masukkan input yang benar: ");
          menumunculpertama = masuk.nextInt();
        }

        if (menumunculpertama == 1) {
          TulisMenu();
          menumunculkedua = masuk.nextInt();
          while ((menumunculkedua != 1 ) && (menumunculkedua != 2) && (menumunculkedua != 3)) {
            System.out.print ("  Silakan masukkan input yang benar: ");
            menumunculkedua = masuk.nextInt();
          }
          if (menumunculkedua == 1) {
            TulisMenuBaca();
            menumunculketiga = masuk.nextInt();

            while ((menumunculketiga != 1 ) && (menumunculketiga != 2) && (menumunculketiga != 3)) {
              System.out.print ("  Silakan masukkan input yang benar: ");
              menumunculketiga = masuk.nextInt();
            }

            if (menumunculketiga == 1) {
              System.out.print ("  Masukkan jumlah baris efektif: ");
              Brs = masuk.nextInt();
              System.out.print ("  Masukkan jumlah kolom efektif: ");
              Kol = masuk.nextInt();
              M1.MakeEmpty(Brs,Kol);
              System.out.println ("  Masukkan elemen matriks:");
              M1.BacaMatriks(Brs,Kol);
              Gauss G1 = new Gauss(M1);
              G1.CreateEchelon();
              System.out.println ("  Matriks eselon: ");
              G1.matriks.TulisMatriks();
              Solution S1 = new Solution(G1.matriks.NKolEff - 1);
              G1.solusi(S1);
              S1.printSolution();

            } else if (menumunculketiga == 2) {
              System.out.println ("  Masukkan nama FileEksternal dengan format .txt (tulis .txt juga)");
              System.out.println ("  (Contoh : aingcupu.txt)");
              System.out.print ("  Nama file : ");
              Scanner sc = new Scanner(System.in);
              namafile = sc.nextLine();
              f.AssignNamaFile(namafile);
              f.BacaMatriksFileSPL (M1,namafile);
              System.out.println();
              System.out.println ("  Matriks yang Anda masukkan adalah:");
              M1.TulisMatriks();
              Gauss G1 = new Gauss(M1);
              G1.CreateEchelon();
              System.out.println ("  Matriks eselon: ");
              G1.matriks.TulisMatriks();
              Solution S1 = new Solution(G1.matriks.NKolEff - 1);
              G1.solusi(S1);
              S1.printSolution();

            } else if (menumunculketiga == 3) {
              break;
            }
          } else if (menumunculkedua == 2) {

            TulisMenuBaca();
            menumunculketiga = masuk.nextInt();

            while ((menumunculketiga != 1 ) && (menumunculketiga != 2) && (menumunculketiga != 3)) {
              System.out.print ("  Silakan masukkan input yang benar: ");
              menumunculketiga = masuk.nextInt();
            }

            if (menumunculketiga == 1) {
              System.out.print ("  Masukkan jumlah baris efektif: ");
              Brs = masuk.nextInt();
              System.out.print ("  Masukkan jumlah kolom efektif: ");
              Kol = masuk.nextInt();
              M1.MakeEmpty(Brs,Kol);
              System.out.println ("  Masukkan elemen matriks:");
              M1.BacaMatriks(Brs,Kol);
              Gauss G1 = new Gauss(M1);
              G1.CreateReducedEchelon();
              System.out.println ("  Matriks eselon tereduksi : ");
              G1.matriks.TulisMatriks();
              Solution S1 = new Solution(G1.matriks.NKolEff - 1);
              G1.solusi(S1);
              S1.printSolution();

            } else if (menumunculketiga == 2) {
              System.out.println ("  Masukkan nama FileEksternal dengan format .txt (tulis .txt juga)");
              System.out.println ("  (Contoh : aingcupu.txt)");
              System.out.print ("  Nama file : ");
              Scanner sc = new Scanner (System.in);
              namafile = sc.nextLine();
              f.AssignNamaFile(namafile);
              f.BacaMatriksFileSPL (M1,namafile);
              System.out.println();
              System.out.println ("  Matriks yang Anda masukkan adalah:");
              M1.TulisMatriks();
              Gauss G1 = new Gauss(M1);
              G1.CreateReducedEchelon();
              System.out.println ("  Matriks eselon tereduksi: ");
              G1.matriks.TulisMatriks();
              Solution S1 = new Solution(G1.matriks.NKolEff - 1);
              G1.solusi(S1);
              S1.printSolution();

          } else if (menumunculketiga == 3) {
            break;
          }

        } else if (menumunculkedua == 3) {
          break;
        }

    } else if (menumunculpertama == 2) { // INTERPOLASI
        TulisMenu();
        menumunculkedua = masuk.nextInt();
        while ((menumunculkedua != 1 ) && (menumunculkedua != 2) && (menumunculkedua != 3)) {
          System.out.print ("  Silakan masukkan input yang benar: ");
          menumunculkedua = masuk.nextInt();
        }

        if (menumunculkedua == 1) {
          TulisMenuBaca();
          menumunculketiga = masuk.nextInt();

          while ((menumunculketiga != 1 ) && (menumunculketiga != 2) && (menumunculketiga != 3)) {
            System.out.print ("  Silakan masukkan input yang benar: ");
            menumunculketiga = masuk.nextInt();
          }

          if (menumunculketiga == 1) {
            System.out.print ("  Masukkan jumlah baris (n): ");
            Brs = masuk.nextInt();
            Kol = 2;
            M1.MakeEmpty(Brs,Kol);
            System.out.println ("  Masukkan elemen x dan y dengan dipisahkan spasi:");
            M1.BacaMatriks(Brs,Kol);
            M1.BuatMatriksInterpolasi(Brs);
            System.out.println ("  Matriks konversi dari inputan user adalah:");
            M1.TulisMatriks();
            Gauss G1 = new Gauss(M1);
            G1.CreateEchelon();
            System.out.println ("  Matriks eselon: ");
            G1.matriks.TulisMatriks();
            Solution solusi = new Solution(G1.matriks.NBrsEff);
            G1.solusi(solusi);
            solusi.printSolutionInterpolasi();
            double msk = 0;
            Scanner sc2 = new Scanner (System.in);
            while (msk != ExitInput) {
              System.out.println ("  Masukkan angka yang ingin Anda taksir!");
              msk = sc2.nextDouble();
              System.out.println ("  Hasil adalah");
              System.out.println (solusi.TaksiranInterpolasi(msk));
            }
          } else if (menumunculketiga == 2) {
            System.out.println ("  Masukkan nama FileEksternal dengan format .txt (tulis .txt juga)");
            System.out.println ("  (Contoh : aingcupu.txt)");
            System.out.print ("  Nama file : ");
            Scanner sc = new Scanner (System.in);
            namafile = sc.nextLine();
            f.AssignNamaFile(namafile);
            f.BacaMatriksFileInterpolasi (M1,namafile);
            System.out.println();
            System.out.println ("  Matriks yang Anda masukkan adalah:");
            M1.TulisMatriks();
            Gauss G1 = new Gauss(M1);
            G1.CreateEchelon();
            System.out.println ("  Matriks eselon: ");
            G1.matriks.TulisMatriks();
            Solution solusi = new Solution(G1.matriks.NBrsEff);
            G1.solusi(solusi);
            solusi.printSolutionInterpolasi();
            double msk = 0;
            Scanner sc2 = new Scanner (System.in);
            while (msk != ExitInput) {
              System.out.println ("  Masukkan angka yang ingin Anda taksir!");
              msk = sc2.nextDouble();

              int pi = 0;
              if (msk != ExitInput){
                while (pi < f.pembagian){
                  msk = msk / 1000;
                  pi++;
                }
              }

              System.out.println ("  Hasil adalah");
              System.out.println (solusi.TaksiranInterpolasi(msk));
            }
          } else if (menumunculketiga == 3) {
            break;
          }
        } else if (menumunculkedua == 2) {
          TulisMenuBaca();
          menumunculketiga = masuk.nextInt();

          while ((menumunculketiga != 1 ) && (menumunculketiga != 2) && (menumunculketiga != 3)) {
            System.out.print ("  Silakan masukkan input yang benar: ");
            menumunculketiga = masuk.nextInt();
          }

          if (menumunculketiga == 1) {
            System.out.print ("  Masukkan jumlah baris (n): ");
            Brs = masuk.nextInt();
            Kol = 2;
            M1.MakeEmpty(Brs,Kol);
            System.out.println ("  Masukkan elemen x dan y dengan dipisahkan spasi:");
            M1.BacaMatriks(Brs,Kol);
            M1.BuatMatriksInterpolasi(Brs);
            System.out.println ("  Matriks konversi dari inputan user adalah:");
            M1.TulisMatriks();
            Gauss G1 = new Gauss(M1);
            G1.CreateEchelon();
            System.out.println ("  Matriks eselon: ");
            G1.matriks.TulisMatriks();
            G1.CreateReducedEchelon();
            System.out.println ("  Matriks reduced eselon: ");
            G1.matriks.TulisMatriks();
            Solution solusi = new Solution(G1.matriks.NBrsEff);
            G1.solusi(solusi);
            solusi.printSolutionInterpolasi();
            double msk = 0;
            Scanner sc2 = new Scanner (System.in);
            while (msk != ExitInput) {
              System.out.println ("  Masukkan angka yang ingin Anda taksir!");
              msk = sc2.nextDouble();
              System.out.println ("  Hasil adalah");
              System.out.println (solusi.TaksiranInterpolasi(msk));
            }
          } else if (menumunculketiga == 2) {
            int pmbg = 0;

            System.out.println ("  Masukkan nama FileEksternal dengan format .txt (tulis .txt juga)");
            System.out.println ("  (Contoh : aingcupu.txt)");
            System.out.print ("  Nama file : ");
            Scanner sc = new Scanner (System.in);
            namafile = sc.nextLine();
            f.AssignNamaFile(namafile);
            f.BacaMatriksFileInterpolasi (M1,namafile);
            System.out.println();
            System.out.println ("  Matriks yang Anda masukkan adalah:");
            M1.TulisMatriks();
            Gauss G1 = new Gauss(M1);
            G1.CreateEchelon();
            System.out.println ("  Matriks eselon: ");
            G1.matriks.TulisMatriks();
            G1.CreateReducedEchelon();
            System.out.println ("  Matriks reduced eselon: ");
            G1.matriks.TulisMatriks();
            Solution solusi = new Solution(G1.matriks.NBrsEff);
            G1.solusi(solusi);
            solusi.printSolutionInterpolasi();
            double msk = 0;
            Scanner sc2 = new Scanner (System.in);
            while (msk != ExitInput) {
              System.out.println ("  Masukkan angka yang ingin Anda taksir!");
              msk = sc2.nextDouble();
              
              int pi = 0;
              if (msk != ExitInput){
                while (pi < f.pembagian){
                  msk = msk / 1000;
                  pi++;
                }
              }

              System.out.println ("  Hasil adalah");
              System.out.println (solusi.TaksiranInterpolasi(msk));
            }
          }
        }
      } else if (menumunculpertama == 3) {
        break;
      }
    }
  }
}
