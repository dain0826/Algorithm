package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dp_9465{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            int answer = Integer.MIN_VALUE;
            int N = Integer.parseInt(br.readLine());
            int[][] dp = new int[2][N];
            int[][] score = new int[2][N];
            for(int i=0; i<2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    score[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            if(N == 1) {
                answer = Math.max(score[0][0], score[1][0]);

            }
            else if(N == 2) {
                answer = Math.max(score[0][0] + score[1][1], score[1][0] + score[0][1]);
            }
            else {
                dp[0][0] = score[0][0];
                dp[1][0] = score[1][0];
                dp[0][1] = dp[1][0] + score[0][1];
                dp[1][1] = dp[0][0] + score[1][1];
                for(int i=2; i<N; i++) {
                    dp[1][i] += Math.max(dp[0][i-1]+score[1][i], dp[0][i-2]+score[1][i]);
                    dp[0][i] += Math.max(dp[1][i-1]+score[0][i], dp[1][i-2]+score[0][i]);
                    answer = Math.max(answer, Math.max(dp[1][i], dp[0][i]));
                }
            }
            System.out.println(answer);
        }
    }
}
