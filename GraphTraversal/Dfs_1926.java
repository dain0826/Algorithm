package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dfs_1926 {
    static int N,M;
    static int[][] arr;
    static boolean[][] visited;
    static int max_size = 0;
    static int count;
    static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j] == 1 && !visited[i][j]){
                    count++;
                    max_size = Math.max(max_size,dfs(i,j));
                }
            }
        }
        System.out.println(count);
        System.out.println(max_size);
    }

    public static int dfs(int x, int y){
        int cnt = 1;
        visited[x][y] = true;
        for(int i=0; i<4; i++){
            int nx = x + delta[i][0];
            int ny = y + delta[i][1];
            if(nx>=0 && ny>=0 && nx<N && ny<M && arr[nx][ny]==1 && !visited[nx][ny]){
                cnt += dfs(nx,ny);
            }
        }
        return cnt;
    }

}
