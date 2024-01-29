package DynamicProgramming;

import java.util.Scanner;

public class Dp_2193 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        long[] D = new long[91];
        D[1] = 1;
        D[2] = 1;
        if(N>2) {
            for (int i = 3; i <= N; i++) {
                D[i] = D[i - 1] + D[i - 2];
            }
        }
        System.out.println(D[N]);
    }
}
