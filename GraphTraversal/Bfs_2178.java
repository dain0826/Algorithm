package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bfs_2178 {
    static int N, M;
    static int[][] A;
    static boolean[][] visited;
    static int[] dx = {0,1,0,-1}; //상 우 하 좌
    static int[] dy = {1,0,-1,0}; //상 우 하 좌
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(bf.readLine());
            String line = st.nextToken();
            for(int j=0;j<M;j++) {
                A[i][j] = Integer.parseInt(line.substring(j,j+1));
            }
        }
        BFS(0,0);
        System.out.println(A[N-1][M-1]);
    }
    public static void BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x,y});
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            visited[x][y] = true;
            for(int i=0;i<4;i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if( nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if(!visited[nx][ny] && A[nx][ny] != 0) {
                        queue.add(new int[] {nx, ny});
                        visited[nx][ny] = true;
                        A[nx][ny] = A[now[0]][now[1]] + 1;
                    }
                }
            }
        }
    }
}
