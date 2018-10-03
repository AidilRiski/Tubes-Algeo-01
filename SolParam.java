import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.*;
import java.text.DecimalFormat;
import java.math.RoundingMode;
import java.lang.*;

public class SolParam{
    public Matriks matriks;
    public String [] SolPar = new String [100];
    public int BrsEff;

    SolParam (int ArrBrsEff){
        MakeArrayString (ArrBrsEff);
    }

    void MakeArrayString (int ArrBrsEff){
      this.BrsEff = ArrBrsEff;
      for (int i = 0; i <= ArrBrsEff; i++){
        this.SolPar[i] ="";
      }
    }


    /** print solusi **/
    public void printParamSolution()
    {
        //int N = sol.length;
        System.out.println("Solusi : ");
        for (int i = 1; i <= this.BrsEff + 1 ; i++) {
          //DecimalFormat df = new DecimalFormat("#.######");
          //df.setRoundingMode(RoundingMode.CEILING);

          //M.Mem[i][j] = Double.parseDouble(df.format(bulat));
          System.out.print("x" + i + " = " + this.SolPar[i] + "\n");
        //  System.out.println();
        }
    }
}
