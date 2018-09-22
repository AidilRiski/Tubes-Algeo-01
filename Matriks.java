class Matriks{
    public Double[][] Mem = new Double[100][100];
    public int NBrsEff;
    public int NKolEff;
    public int IdxBrsMin = 1;
    public int IdxKolMin = 1;

    Matriks(int BrsEff, int KolEff){
        this.NBrsEff = BrsEff;
        this.NKolEff = KolEff;
    }

    void CreateEchelon(){
        for (int i = this.IdxBrsMin; i < this.NBrsEff; i++){
            for (int j = i + 1; j <= this.NBrsEff; j++){
                
            }
        }
    }
}