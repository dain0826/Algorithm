package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bfs_1600 {
    static int K,W,H, answer;
    static int[][] map;
    static boolean[][][] visited;
    static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
    static int[][] holse = {{-1,-2},{-2,-1},{-2,1},{-1,2},{1,-2},{2,-1},{2,1},{1,2}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        visited = new boolean[H][W][K+1];
        answer = -1;

        for(int i=0; i<H; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<W; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
        System.out.println(answer);
    }
    public static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0,0,0,0}); //x,y, 동작수, 말의 움직임 횟수
        visited[0][0][0] = true;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            int move = now[2];
            int cnt = now[3];
            if(x == H-1 && y == W-1){
                answer = move;
                return;
            }
            for(int i=0; i<4; i++){
                int nx = x + delta[i][0];
                int ny = y + delta[i][1];
                if(nx<0 || ny<0 || nx>=H || ny>=W) continue;
                if(map[nx][ny] == 1) continue;
                if(visited[nx][ny][cnt]) continue;
                queue.offer(new int[] {nx,ny,move+1,cnt});
                visited[nx][ny][cnt] = true;
            }
            if(cnt<K){
                for(int i=0; i<8; i++){
                    int nx = x + holse[i][0];
                    int ny = y + holse[i][1];
                    if(nx<0 || ny<0 || nx>=H || ny>=W) continue;
                    if(map[nx][ny] == 1) continue;
                    if(visited[nx][ny][cnt+1]) continue;
                    queue.offer(new int[] {nx,ny,move+1, cnt+1});
                    visited[nx][ny][cnt+1] = true;
                }
            }
        }
    }
}
