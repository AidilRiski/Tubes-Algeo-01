import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class TugasBesarAlgeo{
    public static void main(String[] args){
        /*Matriks M1 = new Matriks(3, 4);
        Gauss G1 = new Gauss(M1);
        M1.BacaMatriks();
        G1.CreateEchelon();
        G1.matriks.TulisMatriks();
        if (G1.isSolvable()){
            System.out.println("Solvable");
        }else {
            System.out.println("Not Solvable");
        }
      */
      FileEksternal f = new FileEksternal();
      f.GetNElmtFileSPL ();
      f.BacaFileSPL();
    }
}
