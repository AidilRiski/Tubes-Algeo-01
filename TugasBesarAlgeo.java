<<<<<<< HEAD
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class TugasBesarAlgeo{
    public static void main(String[] args){
        /*Matriks M1 = new Matriks(3, 4);
=======
import java.util.*;

class TugasBesarAlgeo{
    public static void main(String[] args){
        Matriks M1 = new Matriks(0, 0);
        BacaInput(M1);
>>>>>>> 350da1ae122619626272f8883334f2ad31d8722f
        Gauss G1 = new Gauss(M1);
        G1.matriks.TulisMatriks();
        G1.CleanMatriks();
        G1.matriks.TulisMatriks();
        G1.CreateEchelon();
        G1.matriks.TulisMatriks();
        if (G1.isSolvable()){
            System.out.println("Solvable");
        }else {
            System.out.println("Not Solvable");
        }
<<<<<<< HEAD
      */
      FileEksternal f = new FileEksternal();
      f.GetNElmtFileSPL ();
      f.BacaFileSPL();
=======
        if (G1.isInfiniteSolution()){
            System.out.println("Infinite Solution");
        }else {
            System.out.println("Not Infinite Solution");
        }
        G1.CreateReducedEchelon();
        G1.matriks.TulisMatriks();
    }
    static void BacaInput(Matriks M){
        Scanner input = new Scanner(System.in);
        System.out.print("Jumlah Persamaan: ");
        int m = input.nextInt();
        System.out.print("Jumlah Variabel: ");
        int n = input.nextInt() + 1;
<<<<<<< HEAD
        M.MakeEmpty(n - 1, n);
        M.BacaMatriks(m, n);
=======
        M.MakeEmpty(m, n);
        M.BacaMatriks();
>>>>>>> 350da1ae122619626272f8883334f2ad31d8722f
>>>>>>> a2c9b37f2cadf1b6f254e39a3e460cc3fc42d9a1
    }
}
