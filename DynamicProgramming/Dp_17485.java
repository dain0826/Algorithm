package DynamicProgramming;

import java.util.Scanner;


public class Dp_17485 {
    static final int INF = Integer.MAX_VALUE;
    static int[] delta = {1,0,-1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] map = new int[N][M];
        int[][][] dp = new int[N][M][3];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                map[i][j] = sc.nextInt();

        for (int j = 0; j < M; j++)
            for (int d = 0; d < 3; d++)
                dp[0][j][d] = map[0][j];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int d = 0; d < 3; d++) {
                    dp[i][j][d] = INF;

                    int prevJ = j + delta[d];
                    if (prevJ < 0 || prevJ >= M) continue;

                    for (int prevD = 0; prevD < 3; prevD++) {
                        if (prevD == d || dp[i - 1][prevJ][prevD] == INF) continue; // 같은 방향 연속 금지
                        dp[i][j][d] = Math.min(dp[i][j][d], dp[i - 1][prevJ][prevD] + map[i][j]);
                    }
                }
            }
        }

        int answer = INF;
        for (int j = 0; j < M; j++)
            for (int d = 0; d < 3; d++)
                answer = Math.min(answer, dp[N - 1][j][d]);

        System.out.println(answer);
    }
}
