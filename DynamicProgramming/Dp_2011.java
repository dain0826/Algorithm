package DynamicProgramming;

import java.util.Scanner;

public class Dp_2011 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        int N = s.length();
        int[] dp = new int[N+1];
        dp[0] = 1;
        for(int i=1; i<=N; i++){
            int now = Character.getNumericValue(s.charAt(i-1));
            if(now>=1 && now<= 9){
                dp[i] += dp[i-1];
                dp[i] %= 1000000;
            }
            if(i==1) continue;
            int prev = Character.getNumericValue(s.charAt(i-2));
            if(prev == 0) continue;
            int value = prev * 10 + now;
            if(value>=10 && value<= 26){
                dp[i] += dp[i-2];
                dp[i] %= 1000000;
            }
        }
        System.out.println(dp[N]);
    }
}
