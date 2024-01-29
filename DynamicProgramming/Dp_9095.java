package DynamicProgramming;

import java.util.Scanner;

public class Dp_9095 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for(int i=1; i<=T; i++){
            int[] D = new int[11];
            int N = scan.nextInt();
            D[1] = 1;
            D[2] = 2;
            D[3] = 4;
            if(N>3) {
                for (int j = 4; j <= N; j++) {
                    D[j] = D[j - 1] + D[j - 2] + D[j - 3];
                }
            }
            System.out.println(D[N]);
        }
    }
}
