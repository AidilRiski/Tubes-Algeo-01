import java.util.Scanner;

public class Solution{
    public Matriks matriks;

    Solution(Matriks m){
        this.matriks = m;
    }

    public backSubtitution(){
        int N = this.matriks.NBrsEff;
        double[] solution = new double[N];

        for (int i = N - 1; i >= 0; i--) //Indeks Array Dimulai dari 0; .-.
        {
            double sum = 0.0;
            for (int j = i + 1; j < N; j++) 
                sum += this.matriks.Mem[i][j] * solution[j];
            solution[i] = (this.matriks.Mem[i][this.matriks.NKolEff] - sum) / this.matriks.Mem[i][i];
        } 
    }

    /** print solusi **/
    public void printSolution(double[] sol)
    {
        int N = sol.length;
        System.out.println("\nSolusi : ");
        for (int i = 0; i < N; i++) 
            System.out.printf("%.2f", sol[i]);   
        System.out.println();     
    }
}