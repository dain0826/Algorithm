package DynamicProgramming;

import java.util.Scanner;

public class Dp_1010{

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for(int tc=0; tc<T; tc++) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int[][] B = new int[M+1][N+1];
            for(int i=0;i<=M;i++) {
                for(int j=0, end=Math.min(i, N); j<= end; ++j) {
                    if(j==0 || j==i) B[i][j] = 1;
                    else B[i][j]=B[i-1][j-1]+ B[i-1][j];
                }
            }
            System.out.println(B[M][N]);
        }

    }

}
