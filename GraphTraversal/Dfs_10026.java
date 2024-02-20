package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dfs_10026{
    static int N;
    static char[][] paint;
    static boolean[][] visited;
    static int cnt;
    static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}}; //상하좌우
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        paint = new char[N][N];
        visited = new boolean[N][N];
        for(int i=0; i<N; i++) {
            String line = br.readLine();
            for(int j=0; j<N; j++) {
                paint[i][j] = line.charAt(j);
            }
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j]) {
                    cnt++;
                    RGB(i,j);
                }
            }
        }
        sb.append(cnt + " ");
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(paint[i][j] == 'G') {
                    paint[i][j] = 'R';
                }
            }
        }
        cnt = 0;
        visited = new boolean[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j]) {
                    cnt++;
                    RGB(i,j);
                }
            }
        }
        sb.append(cnt);
        System.out.println(sb);
    }

    public static void RGB(int x, int y) {
        visited[x][y] = true;
        for(int i=0; i<4; i++) {
            int nx = x + delta[i][0];
            int ny = y + delta[i][1];
            if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny] && paint[nx][ny] == paint[x][y]) {
                RGB(nx,ny);
            }
        }
    }

}