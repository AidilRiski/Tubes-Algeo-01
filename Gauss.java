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
    }
    void CreateReducedEchelon(){
        this.CreateEchelon();
        int initialKol = 1;
        for (int j = this.matriks.IdxKolMin; j < this.matriks.NKolEff; j++){
            System.out.println(this.matriks.isAllZeroKol(j));
            if (this.matriks.isAllZeroKol(j)){
                initialKol = j;
                continue;
            }else {
                break;
            }
        }
        System.out.println(initialKol);
        if ((this.matriks.NKolEff - initialKol) + 1 >= this.matriks.NBrsEff){
            for (int i = this.matriks.NBrsEff - 1; i >= this.matriks.IdxBrsMin; i--){
                for (int k = this.matriks.NBrsEff; k > i; k--){

                    
                    System.out.println(k + " " + k);
                    System.out.println(i + " " + k);
                    if (this.matriks.Mem[i][k] != 0){
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
        }
    }
    void CleanMatriks(){
        for (int i = this.matriks.IdxBrsMin; i < this.matriks.NBrsEff; i++){
            System.out.println("Check Cleaning");
            if (this.matriks.isAllZeroBrs(i)){
                System.out.println("Cleaning");
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
}