package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dp_12865 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] weight = new int[N+1];
        int[] price = new int[N+1];
        int[][] dp = new int[N+1][K+1];
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            price[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=K; j++) {
                dp[i][j] = dp[i-1][j];
                if(j-weight[i]>=0) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]] + price[i]);
                }
            }
        }

        System.out.println(dp[N][K]);

    }

}
