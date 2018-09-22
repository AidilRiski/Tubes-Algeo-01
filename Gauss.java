import java.util.*;

class Gauss{
    public static void main(String[] args){
        Matriks M1 = new Matriks(3, 3);
        M1.BacaMatriks();
        CreateEchelon(M1);
        M1.TulisMatriks();
        if (isSolvable(M1)){
            System.out.println("Solvable");
        }else {
            System.out.println("Not Solvable");
        }
    }
    static void CreateEchelon(Matriks M){
        for (int i = M.IdxBrsMin; i < M.NBrsEff; i++){
            for (int j = i + 1; j <= M.NBrsEff; j++){
                if (M.Mem[j][i] != 0){
                    Double multiplier = M.Mem[j][i];
                    Double divider = M.Mem[i][i];
                    for (int k = i;  k <= M.NKolEff; k++){
                        M.Mem[j][k] -= multiplier * M.Mem[i][k] / divider;
                    }
                }
            }
        }
    }
    static boolean isSolvable(Matriks M){
        int i = M.IdxBrsMin;
        while (i <= M.NBrsEff){
            int j = M.IdxKolMin;
            boolean exitJ = false;
            while (j <= M.NKolEff && !exitJ){
                if (M.Mem[i][j] != 0){
                    if (j == M.NKolEff){
                        return false;
                    }else {
                        exitJ = true;
                    }
                }else {
                    j++;
                }
            }
            i++;
        }
        return true;
    }
}