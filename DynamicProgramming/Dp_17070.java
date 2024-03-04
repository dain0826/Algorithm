package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dp_17070{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] home = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                home[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        long[][][] dp = new long[N+1][N+1][3];
        dp[1][2][0] = 1; //처음 파이프는 가로방향으로 놓여져 있다.
        for(int i=1; i<=N; i++){
            for(int j=3; j<=N; j++){ //2번째
                if(home[i][j] ==1) continue; //벽이 있는 자리
                //1. 가로 방향으로 놓을 수 있는 수
                dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];
                //2. 세로 방향으로 놓을 수 있는 수
                if(i==1) continue; //맨 윗줄은 세로,대각선으로 놓을 수 없으므로
                dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];
                //3. 대각선 방향으로 놓을 수 있는 수
                if(home[i][j-1] == 1 || home[i-1][j] == 1) continue; //왼쪽과 위쪽이 벽이면 놓을 수 없으므로
                dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
             }
        }
        System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);


    }

}
