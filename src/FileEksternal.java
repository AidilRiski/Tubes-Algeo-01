import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.*;
import java.text.DecimalFormat;
import java.math.RoundingMode;
import java.lang.*;

class FileEksternal{
  public File file;
  public int pembagian;
  public int pembagian2;

  FileEksternal(){
    this.pembagian = 0;
    this.pembagian2 = 0;
  }

  void AssignNamaFile (String X) throws FileNotFoundException, IOException  {
    this.file = new File (X);
    //this.reader = new BufferedReader(new FileReader(x));
  }

  int GetNElmtFileSPL () {
    int count = 0;
    Scanner scan;
    try {
      scan = new Scanner (this.file);
      while (scan.hasNextDouble()){
        count = count + 1;
        //System.out.println(count);
        scan.next();
      }
    } catch (FileNotFoundException e1){
        //e1.printStackTrace();
    }
    return count;
  }

  int GetNBrsFileSPL (String X) throws FileNotFoundException, IOException  {
    int countBrs = 0;
    BufferedReader reader;
    try {
      reader = new BufferedReader(new FileReader (X));
      while (reader.readLine() != null){
        countBrs++;
        //System.out.println(countBrs);
      }
    } catch (FileNotFoundException e1){
        //e1.printStackTrace();
    }
    return countBrs;
  }

  int GetNKolomFileSPL(String X) throws FileNotFoundException, IOException{
    int countKolom = GetNElmtFileSPL() / GetNBrsFileSPL(X);
    //System.out.println(countKolom);
    return countKolom;
  }

  void BacaMatriksFileSPL (Matriks M, String X) throws FileNotFoundException, IOException{
    M.MakeEmpty (GetNBrsFileSPL(X) , GetNKolomFileSPL(X));
    Scanner scan;
    int i,j;
    try {
      scan = new Scanner (this.file);
      while (scan.hasNextDouble()){
        for (i = M.IdxBrsMin ; i<= M.NBrsEff ; i++) {
          for (j = M.IdxKolMin ; j <= M.NKolEff ; j++) {
            M.Mem[i][j] = scan.nextDouble();
          }
        }
      }
    } catch (FileNotFoundException e1){
        //e1.printStackTrace();
    }
  }

  void BacaMatriksFileInterpolasi (Matriks M, String X) throws FileNotFoundException, IOException{
    M.MakeEmpty (GetNBrsFileSPL(X) , GetNBrsFileSPL(X)+1);
    Scanner scan;
    int i,j;
    double temp;
    double bulat;
    this.pembagian = 0;
    try {
      scan = new Scanner (this.file);
      while (scan.hasNextDouble()){
        for (i = M.IdxBrsMin ; i<= M.NBrsEff ; i++) {
          temp = scan.nextDouble();
          if (this.pembagian == 0){
            while (temp >= 1000){
              temp = temp / 1000;
              this.pembagian++;
            }
          }else {
            int k = 0;
            while (k < this.pembagian){
              temp = temp / 1000;
              k++;
            }
          }
          for (j = M.IdxKolMin ; j <= M.NKolEff ; j++) {
            if (j != M.NKolEff) {
              bulat = (Math.pow(temp,j-1));
              bulat = round(bulat, 6);
              M.Mem[i][j] = bulat;
            }
            else
              M.Mem[i][j] = scan.nextDouble();
          }
        }
      }
    } catch (FileNotFoundException e1){
        System.out.println("  ERROR: FILE TIDAK DITEMUKAN!");
    }
  }
  double round(double value, int places) {
      double scale = Math.pow(10, places);
      return Math.round(value * scale) / scale;
  }
}
