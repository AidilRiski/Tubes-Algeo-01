import java.util.Scanner;

public class Solution{
    public Matriks matriks;

    public backSubtitution(){
        int N = NBrsEff;
        double[] solution = new double[N];
        for (int i = N - 1; i >= 0; i--) 
        {
            double sum = 0.0;
            for (int j = i + 1; j < N; j++) 
                sum += A[i][j] * solution[j];
            solution[i] = (A[i][NKolEff] - sum) / A[i][i];
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