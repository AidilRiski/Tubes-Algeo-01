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