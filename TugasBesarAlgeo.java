import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class TugasBesarAlgeo{
    public static void main(String[] args){
        Matriks M1 = new Matriks(3, 4);
        M1.BacaMatriks(3, 4);
        Gauss G1 = new Gauss(M1);
        G1.CreateEchelon();
        G1.matriks.TulisMatriks();
        G1.CreateReducedEchelon();
        G1.matriks.TulisMatriks();
    }    
}
