package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Bfs_7576 {
    static class Tomato{
        int x,y,time;
        public Tomato(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    static int M,N, day, total, cnt;
    static int[][] box;
    static ArrayList<Tomato> tomatoes;
    static boolean[][] visited;
    static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};

    static boolean flag = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];
        tomatoes = new ArrayList<>();
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == -1){
                    total++;
                }
                else if(box[i][j] == 1){
                    tomatoes.add(new Tomato(i,j,0));
                    visited[i][j] = true;
                    cnt++; //익은 토마토의 갯수
                }
            }
        }
        total = N*M - total; //토마토가 들어있는 칸의 갯수
        bfs();
        System.out.println(flag == true ? day : -1);

    }


    public static void bfs(){
        while(cnt < total){
            int temp = cnt;
            int temp2 = tomatoes.size();
            day++;
            for(int t=0, p=0; p<temp2;p++){
                if(tomatoes.get(t).time == day-1){
                    int cx = tomatoes.get(t).x;
                    int cy = tomatoes.get(t).y;
                    for (int i = 0; i < 4; i++) {
                        int nx = cx + delta[i][0];
                        int ny = cy + delta[i][1];
                        if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && box[nx][ny] == 0) {
                            visited[nx][ny] = true;
                            box[nx][ny] = 1;
                            cnt++;
                            tomatoes.add(new Tomato(nx,ny,day));
                        }
                    }
                    tomatoes.remove(t);
                }
            }
            if(temp == cnt){ //익은 토마토의 갯수에 변함이 없다면
                flag = false; //토마토가 모두 익지 못하는 상황
                return;
            }
        }
    }
}
