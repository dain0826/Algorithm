package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dfs_2573 {
    static int N,M, region, year;
    static int[][] map;
    static boolean[][] visited, svisited;
    static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; m++){
                map[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        while((region = divide())<2){
            if(region == 0){
                System.out.println(0);
                return;
            }
            year++;
            svisited = new boolean[N][M];
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(map[i][j] != 0){
                        svisited[i][j] = true;
                        melt(i,j);
                    }
                }
            }
        }
        System.out.println(year);

    }
    public static int divide(){
        visited = new boolean[N][M];
        int cnt = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] != 0 && !visited[i][j]){
                    cnt++;
                    dfs(i,j);
                }
            }
        }
        return cnt;
    }
    public static void dfs(int x, int y){
        visited[x][y] = true;
        for(int i=0; i<4; i++){
            int nx = x + delta[i][0];
            int ny = y + delta[i][1];
            if(nx>=0 && ny>=0 && nx<N && ny<M && map[nx][ny]>0 && !visited[nx][ny]){
                dfs(nx,ny);
            }
        }
    }
    public static void melt(int x, int y){
        int sea = 0;
        for(int i=0; i<4; i++){
            int nx = x + delta[i][0];
            int ny = y + delta[i][1];
            if(nx>=0 && ny>=0 && nx<N && ny<M && map[nx][ny]==0 && !svisited[nx][ny]){
                sea++;
            }
        }
        map[x][y] = Math.max(0, map[x][y]-sea);
    }

}

