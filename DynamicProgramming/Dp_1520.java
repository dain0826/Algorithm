package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dp_1520 {
    static int M,N;
    static int[][] map;
    static int[][] dp;
    static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        dp = new int[M][N];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        System.out.println(dfs(0,0));

    }
    public static int dfs(int x, int y){
        if(x==M-1 && y==N-1){
            return 1;
        }
        if(dp[x][y] != -1){
            return dp[x][y];
        }
        dp[x][y]=0;
        for(int i=0; i<4; i++){
            int nx = x + delta[i][0];
            int ny = y + delta[i][1];

            if(nx>=0 && ny>=0 && nx<M && ny<N && map[x][y]>map[nx][ny]){
                dp[x][y] += dfs(nx,ny);
            }
        }
        return dp[x][y];
    }

}
