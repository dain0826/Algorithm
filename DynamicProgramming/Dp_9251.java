package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dp_9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] key1 = br.readLine().toCharArray();
        char[] key2 = br.readLine().toCharArray();
        int[][] dp = new int[key1.length+1][key2.length+1]; //공집합 표시

        for(int i=1; i<=key1.length; i++){
            for(int j=1; j<=key2.length; j++){
                if(key1[i-1] == key2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[key1.length][key2.length]);
    }
}
