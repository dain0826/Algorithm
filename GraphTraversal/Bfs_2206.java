package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bfs_2206 {
    static int N,M, answer;
    static int[][] map;
    static boolean[][][] visited;
    static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        answer = Integer.MAX_VALUE;
        visited = new boolean[N][M][2];
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }
        System.out.println(bfs());
    }
    public static int bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0,0,1,0}); //x좌표, y좌표, 이동한 횟수, 벽 부순 횟수
        visited[0][0][0] = true;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            if(now[0] == N-1 && now[1] == M-1) return now[2];
            for(int i=0; i<4; i++){
                int nx = now[0] + delta[i][0];
                int ny = now[1] + delta[i][1];
                if(nx<0 || ny<0 || nx>=N || ny>=M || visited[nx][ny][now[3]]) continue;
                if(map[nx][ny] == 0){ //길이면
                    visited[nx][ny][now[3]] = true;
                    queue.offer(new int[] {nx,ny,now[2]+1, now[3]});

                }
                if(map[nx][ny] == 1) { //벽이면
                    if (now[3] == 0) { //벽을 한번도 부순 적이 없다면
                        visited[nx][ny][1] = true;
                        queue.offer(new int[]{nx, ny, now[2]+1, now[3]+1});
                    }
                }
            }
        }
        return -1;
        }

    }
