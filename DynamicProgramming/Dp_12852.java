package DynamicProgramming;

import java.util.Scanner;

import static java.lang.Math.min;

public class Dp_12852 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = scan.nextInt();
        int[] dp = new int[N+1];
        int[] route = new int[N+1];
        dp[1] = 0;
        for(int i=2; i<= N; i++){
            dp[i] = dp[i-1] + 1;
            route[i] = i-1;

            if(i%2 == 0) {
                if(dp[i/2] + 1 < dp[i]){
                    dp[i] = dp[i/2] + 1;
                    route[i] = i/2;
                }

            }
            if (i % 3 == 0) {
                if(dp[i/3] + 1 < dp[i]){
                    dp[i] = dp[i/3] + 1;
                    route[i] = i/3;
                }
            }
        }
        System.out.println(dp[N]);
        while(N>0){
            sb.append(N + " ");
            N = route[N];
        }
        System.out.println(sb);
    }
}
