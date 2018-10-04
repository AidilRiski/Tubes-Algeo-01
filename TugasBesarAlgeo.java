import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.*;
import java.text.DecimalFormat;
import java.math.RoundingMode;
import java.lang.*;

class TugasBesarAlgeo{


    public static void TulisMenu () {
      System.out.println ("Silakan pilih salah satu menu dibawah berikut!");
      System.out.println ("1. Eliminasi Gauss.");
      System.out.println ("2. Eliminasi Gauss-Jordan");
      System.out.println ("3. Keluar Program ");
      System.out.print ("Ketik '1' atau '2' atau '3' pada keyboard: ");
    }

    public static void TulisMenuBaca () {
      System.out.println ("Silakan pilih salah satu menu dibawah berikut!");
      System.out.println ("1. Baca dari keyboard");
      System.out.println ("2. Baca dari file");
      System.out.println ("3. Keluar Program ");
      System.out.print ("Ketik '1' atau '2' atau '3' pada keyboard: ");
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

      System.out.println ("----------------------------------------");
      System.out.println ("SELAMAT DATANG DI TUGAS BESAR ALJABAR GEOMETRI!");
      System.out.println ("----------------------------------------");
      System.out.println ();

      menumunculpertama = 0;

      while (menumunculpertama != 3){
      System.out.println ("Silakan pilih salah satu menu dibawah berikut!");
      System.out.println ("1. Sistem Persamaan Linier");
      System.out.println ("2. Interpolasi Polinom");
      System.out.println ("3. Keluar Program");
      System.out.print ("Ketik '1' atau '2' atau '3' pada keyboard: ");

      Scanner masuk = new Scanner (System.in);
      menumunculpertama = masuk.nextInt();

      while ((menumunculpertama != 1 ) && (menumunculpertama != 2) && (menumunculpertama != 3)) {
        System.out.print ("Silakan masukkan input yang benar: ");
        menumunculpertama = masuk.nextInt();
      }

        if (menumunculpertama == 1) {
          TulisMenu();
          menumunculkedua = masuk.nextInt();
          while ((menumunculkedua != 1 ) && (menumunculkedua != 2) && (menumunculkedua != 3)) {
            System.out.print ("Silakan masukkan input yang benar: ");
            menumunculkedua = masuk.nextInt();
          }

          if (menumunculkedua == 1) {
              TulisMenuBaca();
              menumunculketiga = masuk.nextInt();

              while ((menumunculketiga != 1 ) && (menumunculketiga != 2) && (menumunculketiga != 3)) {
                System.out.print ("Silakan masukkan input yang benar: ");
                menumunculketiga = masuk.nextInt();
              }

              if (menumunculketiga == 1) {
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
                Solution S1 = new Solution(G1.matriks.NKolEff - 1);
                //SolParam SP = new SolParam(G1.matriks.NBrsEff);
                G1.solusi(S1);
                //G1.backSubtitution(G1.matriks,S1);
                S1.printSolution();
                //S1.PrintSolToFile();

              } else if (menumunculketiga == 2) {
                System.out.println ("Masukkan nama FileEksternal dengan format .txt (tulis .txt juga)");
                System.out.println ("(Contoh : aingcupu.txt)");
                System.out.print ("Nama file : ");
                Scanner sc = new Scanner(System.in);
                namafile = sc.nextLine();
                f.AssignNamaFile(namafile);
                f.BacaMatriksFileSPL (M1,namafile);
                System.out.println();
                System.out.println ("Matriks yang Anda masukkan adalah:");
                M1.TulisMatriks();
                Gauss G1 = new Gauss(M1);
                G1.CreateEchelon();
                System.out.println ("Matriks eselon: ");
                G1.matriks.TulisMatriks();

            } else if (menumunculketiga == 3) {
              break;
            }

          } else if (menumunculkedua == 2) {

            TulisMenuBaca();
            menumunculketiga = masuk.nextInt();

            while ((menumunculketiga != 1 ) && (menumunculketiga != 2) && (menumunculketiga != 3)) {
              System.out.print ("Silakan masukkan input yang benar: ");
              menumunculketiga = masuk.nextInt();
            }

            if (menumunculketiga == 1) {
              System.out.print ("Masukkan jumlah baris efektif: ");
              Brs = masuk.nextInt();
              System.out.print ("Masukkan jumlah kolom efektif: ");
              Kol = masuk.nextInt();
              M1.MakeEmpty(Brs,Kol);
              System.out.println ("Masukkan elemen matriks:");
              M1.BacaMatriks(Brs,Kol);
              Gauss G1 = new Gauss(M1);
              G1.CreateReducedEchelon();
              System.out.println ("Matriks eselon tereduksi : ");
              G1.matriks.TulisMatriks();

            } else if (menumunculketiga == 2) {
              System.out.println ("Masukkan nama FileEksternal dengan format .txt (tulis .txt juga)");
              System.out.println ("(Contoh : aingcupu.txt)");
              System.out.print ("Nama file : ");
              Scanner sc = new Scanner(System.in);
              namafile = sc.nextLine();
              f.AssignNamaFile(namafile);
              f.BacaMatriksFileSPL (M1,namafile);
              System.out.println();
              System.out.println ("Matriks yang Anda masukkan adalah:");
              M1.TulisMatriks();
              Gauss G1 = new Gauss(M1);
              G1.CreateReducedEchelon();
              System.out.println ("Matriks eselon tereduksi: ");
              G1.matriks.TulisMatriks();

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
        System.out.print ("Silakan masukkan input yang benar: ");
        menumunculkedua = masuk.nextInt();
      }

      if (menumunculkedua == 1) {
          TulisMenuBaca();
          menumunculketiga = masuk.nextInt();

          while ((menumunculketiga != 1 ) && (menumunculketiga != 2) && (menumunculketiga != 3)) {
            System.out.print ("Silakan masukkan input yang benar: ");
            menumunculketiga = masuk.nextInt();
          }

          if (menumunculketiga == 1) {
            System.out.print ("Masukkan jumlah baris (n): ");
            Brs = masuk.nextInt();
            Kol = 2;
            M1.MakeEmpty(Brs,Kol);
            System.out.println ("Masukkan elemen x dan y dengan dipisahkan spasi:");
            M1.BacaMatriks(Brs,Kol);
            M1.BuatMatriksInterpolasi(Brs);
            System.out.println ("Matriks konversi dari inputan user adalah:");
            M1.TulisMatriks();
            Gauss G1 = new Gauss(M1);
            G1.CreateEchelon();
            System.out.println ("Matriks eselon: ");
            G1.matriks.TulisMatriks();
            Solution solusi = new Solution(G1.matriks.NBrsEff);
            G1.solusi(solusi);
            solusi.printSolutionInterpolasi();

          } else if (menumunculketiga == 2) {
            System.out.println ("Masukkan nama FileEksternal dengan format .txt (tulis .txt juga)");
            System.out.println ("(Contoh : aingcupu.txt)");
            System.out.print ("Nama file : ");
            Scanner sc = new Scanner(System.in);
            namafile = sc.nextLine();
            f.AssignNamaFile(namafile);
            f.BacaMatriksFileInterpolasi (M1,namafile);
            System.out.println();
            System.out.println ("Matriks yang Anda masukkan adalah:");
            M1.TulisMatriks();
            Gauss G1 = new Gauss(M1);
            G1.CreateEchelon();
            System.out.println ("Matriks eselon: ");
            G1.matriks.TulisMatriks();

        } else if (menumunculketiga == 3) {
          break;
        }
      } else if (menumunculkedua == 2) {
        /*System.out.print ("Masukkan jumlah baris (n): ");
        Brs = masuk.nextInt();
        Kol = 2;
        M1.MakeEmpty(Brs,Kol);
        System.out.println ("Masukkan elemen x dan y dengan dipisahkan spasi:");
        M1.BacaMatriks(Brs,Kol);
        M1.BuatMatriksInterpolasi(Brs);
        System.out.println ("Matriks konversi dari inputan user adalah:")
        M1.TulisMatriks(); */

        /*Gauss G1 = new Gauss(M1);
        G1.CreateReducedEchelon();
        System.out.println ("Matriks eselon tereduksi : ");
        G1.matriks.TulisMatriks(); */

      }
    } else if (menumunculpertama == 3) {
      break;
    }
  }
}
}
