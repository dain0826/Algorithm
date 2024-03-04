package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bfs_14502 {
    static class Virus{
        int x,y;
        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N, M;
    static int[][] lab, copy;
    static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}}; //바이러스 상하좌우로 이동
    static ArrayList<Virus> virus;
    static int max = Integer.MIN_VALUE;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lab = new int[N][M];
        virus = new ArrayList<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if(lab[i][j] == 2) {
                    virus.add(new Virus(i,j));
                }
            }
        }
        setWall(0);
        System.out.println(max);

    }
    public static void setWall(int c) {
        if(c == 3) { //벽을 다 세웠다면
            infect(); //바이러스 전파
            max = Math.max(safe(), max); //안전영역 수 업데이트
            return;
        }
        else {
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(lab[i][j] == 0) { //빈 칸이면
                        lab[i][j] = 1; // 벽 세우고
                        setWall(c+1); //다음 벽 세우기
                        lab[i][j] = 0; // 벽 되돌리기
                    }
                }
            }
        }
    }

    public static void infect() { //바이러스 전파
        visited = new boolean[N][M];
        copyLab();
        for(int i=0; i<virus.size(); i++) {
            Queue<int[]> queue = new LinkedList<>();
            int x = virus.get(i).x;
            int y = virus.get(i).y;
            visited[x][y] = true;
            queue.offer(new int[] {x,y});
            while(!queue.isEmpty()) {
                int[] now = queue.poll();
                int cx = now[0];
                int cy = now[1];
                for(int d=0; d<4; d++) {
                    int nx = cx + delta[d][0];
                    int ny = cy + delta[d][1];
                    if(nx>=0 && ny>=0 && nx<N && ny<M && !visited[nx][ny] && copy[nx][ny]!=1) { //범위내 && 미방문 && 벽이 아니라면
                        visited[nx][ny] = true;
                        copy[nx][ny] = 1; //바이러스전파성공
                        queue.offer(new int[] {nx,ny});
                    }
                }
            }
        }
    }

    public static void copyLab() { //맵 복사
        copy = new int[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                copy[i][j] = lab[i][j];
            }
        }
    }
    public static int safe() { //안전영역 수 찾기
        int cnt = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(copy[i][j] == 0) { //빈 칸이라면
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
