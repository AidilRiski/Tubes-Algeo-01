class Gauss{
    public static void main(String[] args){
        Matriks M1 = new Matriks(3, 3);
        M1.BacaMatriks();
        CreateEchelon(M1);
        M1.TulisMatriks();
    }
    static void CreateEchelon(Matriks M){
        for (int i = M.IdxBrsMin; i < M.NBrsEff; i++){
            for (int j = i + 1; j <= M.NBrsEff; j++){
                Double multiplier = M.Mem[j][i];
                Double divider = M.Mem[i][i];
                for (int k = i;  k <= M.NKolEff; k++){
                    M.Mem[j][k] -= multiplier * M.Mem[i][k] / divider;
                }
            }
        }
    }
}