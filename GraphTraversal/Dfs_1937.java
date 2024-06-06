package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dfs_1937 {
    static int N;
    static int[][] map;
    static int[][] dp;
    static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                answer = Math.max(answer, dfs(i,j));
            }
        }
        System.out.println(answer);

    }
    static int dfs(int x, int y){
        if(dp[x][y]!=0) return dp[x][y];
        dp[x][y]=1;
        for(int d=0; d<4; d++){
            int nx = x + delta[d][0];
            int ny = y + delta[d][1];
            if(nx>=0 && ny>=0 && nx<N && ny<N  && map[nx][ny]>map[x][y]){
                dp[x][y] = Math.max(dp[x][y], dfs(nx,ny)+1);
            }
        }
        return dp[x][y];
    }
}
