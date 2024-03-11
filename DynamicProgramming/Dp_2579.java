package DynamicProgramming;

import java.util.Scanner;

public class Dp_2579 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int stair[] = new int[N+1];
        int dp[] = new int[N+1];
        for(int i=1; i<=N; i++){
            stair[i] = scan.nextInt();
        }
        if(N>=1){
            dp[1]=stair[1];
        }
        if(N>=2){
            dp[2]=dp[1] + stair[2];
        }
        if(N>=3){
            dp[3]=Math.max(stair[1]+stair[3], stair[2]+stair[3]);
        }
        if(N>=4){
            for(int i=4; i<=N; i++){
                dp[i] = Math.max(dp[i-3]+stair[i-1]+stair[i], dp[i-2]+stair[i]);
            }
        }
        System.out.println(dp[N]);
    }
}