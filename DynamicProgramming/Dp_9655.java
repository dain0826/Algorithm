package DynamicProgramming;

import java.util.Scanner;

public class Dp_2193 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] D = new int[N+1];
        D[1] = 1;
        D[2] = 2;
        D[3] = 1;
        for(int i=4; i<=N; i++){
            D[i] = Math.min(D[i-1], D[i-3]) + 1;
        }
        if(D[N] % 2 == 0){
            System.out.println("CY");
        }
        else System.out.println("SK");
    }
}
