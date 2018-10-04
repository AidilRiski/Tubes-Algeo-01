import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.*;
import java.text.DecimalFormat;
import java.math.RoundingMode;
import java.lang.*;

public class Solution{
    public Matriks matriks;
    public String [] Sol = new String [100];
    public int BrsEff;

    Solution (int ArrBrsEff){
        MakeArray (ArrBrsEff);
    }

    void MakeArray (int ArrBrsEff) {
      this.BrsEff = ArrBrsEff;
      for (int i = 0 ; i <= ArrBrsEff ; i++) {
        this.Sol[i] = "";
      }
    }


    /** print solusi **/

    void printSolution () throws Exception {
      try {
        FileOutputStream fout = new FileOutputStream("SolusiSPL.txt");
        System.out.print("Solusi: \n");
        for (int i = 1 ; i <= this.BrsEff ; i++) {
          //DecimalFormat df = new DecimalFormat("#.######");
          String s = "x" + Integer.toString(i) + " = " + this.Sol[i];
          System.out.print(s + "\n");
          byte b[] = s.getBytes();
          fout.write(b);
          fout.write(System.getProperty("line.separator").getBytes());
        }
        fout.flush();
        fout.close();
      } catch(Exception e) {
        System.out.println(e);
      }

    }

    void printSolutionInterpolasi () throws Exception {
      try {
        System.out.print("f(x) = ");
        for (int i = 1 ; i <= this.BrsEff ; i++) {
          String s = this.Sol[i] + "x^" + Integer.toString(i - 1);
          if (Integer.parseInt(this.Sol[i]) != 0){
            System.out.print(s);
          }
          if (i < this.BrsEff){
            if (Integer.parseInt(this.Sol[i + 1]) != 0){
              System.out.print(" + ");
            }
          }
        }
        System.out.println();
      } catch(Exception e) {
        System.out.println(e);
      }
    }
}
