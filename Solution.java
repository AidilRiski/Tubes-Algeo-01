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
    public Double [] Sol = new Double [100];
    public int BrsEff;

    Solution (int ArrBrsEff){
        MakeArray (ArrBrsEff);
    }

    void MakeArray (int ArrBrsEff) {
      this.BrsEff = ArrBrsEff;
      for (int i = 0 ; i <= ArrBrsEff ; i++) {
        this.Sol[i] = 0.0;
      }
    }


    /** print solusi **/

    public void printSolution()
    {
        //int N = sol.length;
        System.out.println("Solusi : ");
        for (int i = 1; i <= this.BrsEff ; i++) {
          DecimalFormat df = new DecimalFormat("#.######");
          //df.setRoundingMode(RoundingMode.CEILING);

          //M.Mem[i][j] = Double.parseDouble(df.format(bulat));
          System.out.print("X" + i + " = " + df.format(this.Sol[i]) + "\n");
        //  System.out.println();
        }

        System.out.println();
    }

    public void PrintSolToFile () throws Exception {
      try {
        FileOutputStream fout = new FileOutputStream("SolusiSPL.txt");

        for (int i = 1 ; i <= this.BrsEff ; i++) {
          DecimalFormat df = new DecimalFormat("#.######");
          String s = "x" + Integer.toString(i) + " = " + df.format(this.Sol[i]);
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
}
