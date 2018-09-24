import java.util.*;

class TugasBesarAlgeo{
    public static void main(String[] args){
        Matriks M1 = new Matriks(0, 0);
        BacaInput(M1);
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
        M.MakeEmpty(n - 1, n);
        M.BacaMatriks(m, n);
    }
}