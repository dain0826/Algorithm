package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Swea_1249 {
    static int N;
    static int[][] map;
    static int[][] dist;
    static int answer;
    static boolean[][] visited;
    static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visited = new boolean[N][N];
            dist = new int[N][N];
            answer = Integer.MAX_VALUE;
            for(int i=0; i<N; i++) {
                String s = br.readLine();
                for(int j=0; j<N; j++) {
                    map[i][j] = Character.getNumericValue(s.charAt(j));
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
            bfs();
            System.out.println("#" + t + " " + answer);
        }

    }
    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0,0});
        visited[0][0] = true;
        dist[0][0] = 0;
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];

            if(x == N-1 && y == N-1) {
                answer = Math.min(answer, dist[x][y]);
            }
            for(int i=0; i<4; i++) {
                int nx = x + delta[i][0];
                int ny = y + delta[i][1];
                if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
                if(visited[nx][ny] && dist[nx][ny] <= (dist[x][y]+map[nx][ny])) continue;
                visited[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + map[nx][ny];
                queue.offer(new int[] {nx,ny});
            }
        }
    }


}
