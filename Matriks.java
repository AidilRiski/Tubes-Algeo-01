import java.util.*;

class Matriks{
    public Double[][] Mem = new Double[100][100];
    public int NBrsEff;
    public int NKolEff;
    public int IdxBrsMin = 1;
    public int IdxKolMin = 1;

    Matriks(int BrsEff, int KolEff){
        MakeEmpty(BrsEff, KolEff);
    }
    void MakeEmpty(int BrsEff, int KolEff){
        this.NBrsEff = BrsEff;
        this.NKolEff = KolEff;
        for (int i = this.IdxBrsMin; i <= this.NBrsEff; i++){
            for (int j = this.IdxKolMin; j <= this.NKolEff; j++){
                this.Mem[i][j] = 0.0;
            }
        }
    }
    void BacaMatriks(int brsMax, int kolMax){
        Scanner input = new Scanner(System.in);
        for (int i = this.IdxBrsMin; i <= brsMax; i++){
            for (int j = this.IdxKolMin; j <= kolMax; j++){
                this.Mem[i][j] = input.nextDouble();
            }
        }
    }
    void TulisMatriks(){
        for (int i = this.IdxBrsMin; i <= this.NBrsEff; i++){
            for (int j = this.IdxKolMin; j <= this.NKolEff; j++){
                System.out.print(this.Mem[i][j]);
                if (j < this.NKolEff){
                    System.out.print(" ");
                }else if (j == this.NKolEff){
                    System.out.println();
                }
            }
        }
    }
    boolean isAllZeroBrs(int idxBrs){
        int j = this.IdxKolMin;
        while (j <= this.NKolEff){
            if (this.Mem[idxBrs][j] != 0){
                return false;
            }
            j++;
        }
        return true;
    }
    boolean isAllZeroKol(int idxKol){
        int i = this.IdxBrsMin;
        while (i <= this.NBrsEff){
            if (this.Mem[i][idxKol] != 0){
                return false;
            }
            i++;
        }
        return true;
    }
    void TukarBrs(int idxBrs1, int idxBrs2){
        Double temp;
        int j;
        for(j=1; j<=this.NKolEff;j++){
            temp = this.Mem[idxBrs1][j];
            this.Mem[idxBrs1][j] = this.Mem[idxBrs2][j];
            this.Mem[idxBrs2][j] = temp;
        }
    }
    void IdentifyBrs(int idxBrs){
        
        boolean found = false;
        Double divider = 0.0;
        int j = this.IdxKolMin;
        while (j <= this.NKolEff){
            if (!found && this.Mem[idxBrs][j] != 0){
                divider = this.Mem[idxBrs][j];
                found = true;
                j--;
            }else if (found){
                this.Mem[idxBrs][j] = this.Mem[idxBrs][j] / divider;
            }
            j++;
        }
        
    }
}