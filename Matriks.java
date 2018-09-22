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
    void BacaMatriks(){
        Scanner input = new Scanner(System.in);
        for (int i = this.IdxBrsMin; i <= this.NBrsEff; i++){
            for (int j = this.IdxKolMin; j <= this.NKolEff; j++){
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
}