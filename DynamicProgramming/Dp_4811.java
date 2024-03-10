package DynamicProgramming;

import java.util.Scanner;

public class Dp_4811 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long[] dp = new long[31];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<= 30; i++){
            long cnt = 0;
            for(int j=0; j<i; j++){
                cnt += dp[j] * dp[i-j-1];
            }
            dp[i] = cnt;
        }
        while(true){
            int N = scan.nextInt();
            if(N==0){
                break;
            }
            System.out.println(dp[N]);
        }
    }
}
