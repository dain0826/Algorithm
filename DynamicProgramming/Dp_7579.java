package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dp_7579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] m = new int[N+1];
        int[] c = new int[N+1];
        int[][] dp = new int[N+1][10001];
        int answer = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            m[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            c[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1; i<=N; i++){
            for(int j=0; j<= 10000; j++){
                if(i==1){
                    if(j>=c[i]) dp[i][j] =m[i];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                    if(j>=c[i]){
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][j-c[i]] + m[i]);
                    }
                }
                if(dp[i][j] >= M){
                    answer = Math.min(answer, j);
                }
            }
        }
        System.out.println(answer);
    }
}
