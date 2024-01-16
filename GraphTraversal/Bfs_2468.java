package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bfs_2468 {
    static int N;
    static int[] dx = { 0,1,0,-1};
    static int[] dy = { 1,0,-1,0};
    static int[][] town;
    static boolean[][] visited;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        town = new int[N][N];
        visited = new boolean[N][N];

        int max = 0;
        int count = 0;
        int answer = 0;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<N; j++) {
                town[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, town[i][j]);
            }
        }
        for(int i=0; i<max; i++) {
            visited = new boolean[N][N];
            count = 0;
            for(int j=0; j<N; j++) {
                for(int r=0; r<N; r++) {
                    if(town[j][r] > i && !visited[j][r]) {
                        BFS(j,r,i);
                        count++;
                    }
                }
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }
    public static void BFS(int x, int y, int h){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x,y});
        while(!queue.isEmpty()){
            int now[] = queue.poll();
            visited[x][y] = true;
            for(int k=0; k<4; k++) {
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];
                if(nx>=0 && ny >=0 && nx <N && ny <N){
                    if(!visited[nx][ny] && town[nx][ny] > h) {
                        visited[nx][ny] = true;
                        queue.offer(new int[] {nx,ny});
                    }
                }
            }
        }
    }
}
