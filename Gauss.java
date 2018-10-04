import java.util.*;
import java.text.DecimalFormat;
import java.math.RoundingMode;
import java.lang.*;
//import com.sun.javafx.scene.web.Printable;

class Gauss{
    public Matriks matriks;

    Gauss(Matriks m){
        this.matriks = m;
    }

    void CreateEchelon(){
        /*
        for (int i = this.matriks.IdxBrsMin; i < this.matriks.NBrsEff; i++){
            for (int j = i + 1; j <= this.matriks.NBrsEff; j++){
                if (j <= this.matriks.NKolEff){
                    if (this.matriks.Mem[j][i] != 0){
                        Double multiplier = this.matriks.Mem[j][i];
                        Double divider = this.matriks.Mem[i][i];
                        for (int k = i;  k <= this.matriks.NKolEff; k++){
                            //System.out.println(i + " " + j + " " + k);
                            this.matriks.Mem[j][k] -= multiplier * this.matriks.Mem[i][k] / divider;
                        }
                    }
                }
            }
        }*/

        int brsPivot = this.matriks.IdxBrsMin;
        int kolPivot = this.matriks.IdxKolMin;

        int maxBrsPivot = brsPivot;
        int maxKolPivot = kolPivot;
        
        while (maxBrsPivot < this.matriks.NBrsEff && maxKolPivot < this.matriks.NKolEff){
            maxBrsPivot++;
            maxKolPivot++;
        }

        int i = brsPivot + 1;
        int j = kolPivot;

        while (i <= this.matriks.NBrsEff){
            int ubahPivot = brsPivot + 1;
            while (ubahPivot <= this.matriks.NBrsEff && this.matriks.Mem[brsPivot][kolPivot] == 0){
                this.matriks.TukarBrs(brsPivot, ubahPivot);
                ubahPivot++;
            }
            if (this.matriks.Mem[brsPivot][kolPivot] != 0){
                if (this.matriks.Mem[i][j] != 0){
                    //System.out.println(brsPivot + " " + kolPivot + " " + i + " " + j);
                    Double divider = this.matriks.Mem[brsPivot][kolPivot];
                    Double multiplier = this.matriks.Mem[i][j];
                    for (int n = this.matriks.IdxKolMin; n <= this.matriks.NKolEff; n++){
                        this.matriks.Mem[i][n] -= multiplier * this.matriks.Mem[brsPivot][n] / divider;
                    }
                    this.matriks.TulisMatriks();
                }
                if (i < this.matriks.NBrsEff){
                    i++;
                }else {
                    if (j < maxKolPivot){
                        brsPivot++;
                        kolPivot++;
                        i = brsPivot + 1;
                        j++;
                    }else {
                        i++;
                    }
                }
            }else {
                brsPivot++;
                kolPivot++;
                i = brsPivot + 1;
                j++;
            }
        }

        for (int a = this.matriks.IdxBrsMin; a <= this.matriks.NBrsEff; a++){
            this.matriks.IdentifyBrs(a);
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
                    System.out.println("AS " + i + " " + (i + j) + " " + k + " " + c + " " + found);
                    if (i <= this.matriks.NBrsEff && i + j <= this.matriks.NKolEff){
                        if (this.matriks.Mem[i + c][i + j] != 0){
                            found = true;
                        }else {
                            c++;
                        }
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

    public void backSubtitution (Solution S1){
        System.out.println (this.matriks.Mem[this.matriks.NBrsEff][this.matriks.NKolEff]);
        for (int i = this.matriks.NBrsEff; i > 0; i--)
        {
            double sum = 0.0;
            for (int j = i+1; j <= this.matriks.NBrsEff; j++) {
              //System.out.print ("Iterasi ke-");
              //System.out.println(j);
              //System.out.println (this.matriks.Mem[i][j]);
              sum = sum + (this.matriks.Mem[i][j]* Double.parseDouble(S1.Sol[j]));
            }
            double temp = (this.matriks.Mem[i][this.matriks.NKolEff] - sum) / this.matriks.Mem[i][i];
            DecimalFormat df = new DecimalFormat("#.######");
            S1.Sol[i] = df.format(temp);
        }
        this.CreateReducedEchelon();
    }

    public void paramSol (Solution S1){
        int varBebas = this.matriks.NKolEff - (this.matriks.NBrsEff + 1);
        char[] varIsi = new char[varBebas];
        int[] idxAda = new int[this.matriks.NBrsEff+1];
        char isi = 'a';
        int i = 1;
        int j = 1;
        Double e = 0.0001;

        this.CreateReducedEchelon();

        while (j < this.matriks.NKolEff){
            if (this.matriks.Mem[i][j] == 1){
                idxAda[i] = j;
                i++;
            } else {
                S1.Sol[j] = Character.toString(isi);
                isi = (char)((int)isi + 1);
            }
            j++;
        }

        for (int k = 1; k <= this.matriks.NBrsEff; k++ ){
            String sumParam = "";
            for (int l = this.matriks.NKolEff - 1; l > idxAda[k]; l--){
                if( Math.abs(this.matriks.Mem[k][l]) > e){
                  if (this.matriks.Mem[k][l] < 0) {
                    sumParam += " + " + Double.toString(Math.abs(this.matriks.Mem[k][l])) + S1.Sol[l];
                  } else {
                    sumParam += " - " + Double.toString(this.matriks.Mem[k][l]) + S1.Sol[l];
                  }

                }
            }
            S1.Sol[idxAda[k]] = Double.toString(this.matriks.Mem[k][this.matriks.NKolEff]) + sumParam;
        }
    }

    public void solusi (Solution S1){
        if(this.matriks.NKolEff != this.matriks.NBrsEff + 1){
            paramSol(S1);
        } else if (this.isInfiniteSolution()){
          paramSol(S1);

        } else {
          backSubtitution(S1);
        }
    }

}
