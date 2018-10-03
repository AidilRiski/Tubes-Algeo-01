import java.util.*;

class Gauss{
    public Matriks matriks;

    Gauss(Matriks m){
        this.matriks = m;
    }

    void CreateEchelon(){
        for (int i = this.matriks.IdxBrsMin; i < this.matriks.NBrsEff; i++){
            for (int j = i + 1; j <= this.matriks.NBrsEff; j++){
                if (this.matriks.Mem[j][i] != 0){
                    Double multiplier = this.matriks.Mem[j][i];
                    Double divider = this.matriks.Mem[i][i];
                    for (int k = i;  k <= this.matriks.NKolEff; k++){
                        this.matriks.Mem[j][k] -= multiplier * this.matriks.Mem[i][k] / divider;
                    }
                }
            }
        }
        for (int i = this.matriks.IdxBrsMin; i <= this.matriks.NBrsEff; i++){
            this.matriks.IdentifyBrs(i);
        }
    }
    void CreateReducedEchelon(){
        this.CreateEchelon();
        int initialKol = 1;
        for (int j = this.matriks.IdxKolMin; j < this.matriks.NKolEff; j++){
            //System.out.println(this.matriks.isAllZeroKol(j));
            if (this.matriks.isAllZeroKol(j)){
                initialKol = j;
                continue;
            }else {
                break;
            }
        }
        int i = this.matriks.IdxBrsMin;
        int j = 1;
        int k = this.matriks.NBrsEff;
        while (i <= k){
            if (i == k){
                i = this.matriks.IdxBrsMin;
                j++;
                k--;
            }else {
                boolean found = false;
                int c = 1;
                while (!found && c <= this.matriks.NBrsEff - i){
                    if (this.matriks.Mem[i + c][i + j] != 0){
                        found = true;
                    }else {
                        c++;
                    }
                }
                int jj = this.matriks.IdxKolMin;
                while (found && jj < i + j){
                    if (this.matriks.Mem[i][jj] == 0 && this.matriks.Mem[i + c][jj] != 0){
                        found = false;
                    }else {
                        jj++;
                    }
                }
                //System.out.println(i + " " + (i + j) + " " + k + " " + c + " " + found);
                if (found && this.matriks.Mem[i][i + j] != 0){
                    Double multiplier = this.matriks.Mem[i][i + j];
                    Double divider = this.matriks.Mem[i + c][i + j];
                    for (int n = this.matriks.IdxKolMin; n <= this.matriks.NKolEff; n++){
                        this.matriks.Mem[i][n] -= multiplier * this.matriks.Mem[i + c][n] / divider;
                    }
                }
                i++;
            }
        }
        /*
        if ((this.matriks.NKolEff - initialKol) + 1 >= this.matriks.NBrsEff){
            for (int i = this.matriks.NBrsEff - 1; i >= this.matriks.IdxBrsMin; i--){
                for (int k = this.matriks.NBrsEff; k > i; k--){


                    System.out.println(k + " " + k);
                    System.out.println(i + " " + k);
                    if (this.matriks.Mem[i][k] != 0 && this.matriks.Mem[k][k] != 0){
                        Double multiplier = this.matriks.Mem[i][k];
                        Double divider = this.matriks.Mem[k][k];
                        for (int j = this.matriks.IdxKolMin; j <= this.matriks.NKolEff; j++){
                            this.matriks.Mem[i][j] -= multiplier * this.matriks.Mem[k][j] / divider;
                        }
                    }
                    this.matriks.TulisMatriks();
                    System.out.println("");

                }
            }
        }*/
        for (int a = this.matriks.IdxBrsMin; a <= this.matriks.NBrsEff; a++){
            this.matriks.IdentifyBrs(a);
        }
    }
    void CleanMatriks(){
        for (int i = this.matriks.IdxBrsMin; i < this.matriks.NBrsEff; i++){
            if (this.matriks.isAllZeroBrs(i)){
                for (int k = this.matriks.IdxKolMin; k <= this.matriks.NKolEff; k++){
                    this.matriks.Mem[i][k] = this.matriks.Mem[i + 1][k];
                    this.matriks.Mem[i + 1][k] = 0.0;
                }
            }
        }
    }
    boolean isSolvable(){
        int i = this.matriks.IdxBrsMin;
        while (i <= this.matriks.NBrsEff){
            int j = this.matriks.IdxKolMin;
            boolean exitJ = false;
            while (j <= this.matriks.NKolEff && !exitJ){
                if (this.matriks.Mem[i][j] != 0){
                    if (j == this.matriks.NKolEff){
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
    boolean isInfiniteSolution(){
        if (this.isSolvable()){
            int i = this.matriks.IdxBrsMin;
            while (i <= this.matriks.NBrsEff && i <= this.matriks.NKolEff - 1){
                int j = this.matriks.IdxKolMin;
                boolean exitJ = false;
                while (j <= this.matriks.NKolEff && !exitJ){
                    if (this.matriks.Mem[i][j] != 0){
                        exitJ = true;
                    }else {
                        if (j < this.matriks.NKolEff){
                            j++;
                        }else {
                            return true;
                        }
                    }
                }
                i++;
            }
            return false;
        }else {
            return false;
        }
    }

    public void backSubtitution (Matriks M1, Solution S1){
        //int N = this.matriks.NBrsEff;
        //double[] solution = new double[M1.NBrsEff];

        //MakeArray(M1.NBrsEff);
        //System.out.println (S1.Sol[0]);
        System.out.println (M1.Mem[M1.NBrsEff][M1.NKolEff]);
        for (int i = M1.NBrsEff; i > 0; i--)
        {
            double sum = 0.0;
            for (int j = i+1; j <= M1.NBrsEff; j++) {
              System.out.print ("Iterasi ke-");
              System.out.println(j);
              System.out.println (M1.Mem[i][j]);
              //this.Sol[j] = 0.0;
              sum = sum + (M1.Mem[i][j]* S1.Sol[j]);
            }
            S1.Sol[i] = (M1.Mem[i][M1.NKolEff] - sum) / M1.Mem[i][i];
            //System.out.println (sum);
        }
    }

    public void paramSol (Matriks M1, SolParam SP){
        int varBebas = M1.NKolEff - (M1.NBrsEff + 1);
        char[] varIsi = new char[varBebas];
        int[] idxAda = new int[M1.NBrsEff+1];
        //String[] solParam = new String[M1.NKolEff];
        char isi = 'a';
        // /String sumParam;
        int i = 1;
        int j = 1;
        Double e = 0.0001;
        
        //Ubah Ke Gauss-Jordan
        //M1.CreateReducedEchelon();
        //Assign Freevar
        while (j < M1.NKolEff){
            if (M1.Mem[i][j] == 1){
                idxAda[i] = j;
                i++;
            } else {
                SP.SolPar[j] = Character.toString(isi);
                isi = (char)((int)isi + 1);
            }
            j++;
        }

        //Assign Solution
        for (int k = 1; k <= M1.NBrsEff; k++ ){
            //System.out.print("Aku");
            String sumParam = "";
            for (int l = M1.NKolEff - 1; l > idxAda[k]; l--){
                if( Math.abs(M1.Mem[k][l]) > e){
                    sumParam += " -" + Double.toString(M1.Mem[k][l]) + SP.SolPar[l];
                }
            }
            SP.SolPar[idxAda[k]] = Double.toString(M1.Mem[k][M1.NKolEff]) + sumParam;
        }
    }

    /*public void printSolution()
    {
        //int N = sol.length;
        System.out.println("Solusi : ");
        for (int i = 0; i < this.BrsEff ; i++)
            System.out.print(/*"%.2f",this.Sol[i]);
    /*    System.out.println();
  } */

}
