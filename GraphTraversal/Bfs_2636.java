package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bfs_2636{
    static int R, C, hour;
    static int[][] time;
    static boolean[][] cheese;
    static boolean[][] melt;
    static boolean[][] checked;
    static int[][] delta = {{-1,0}, {1,0}, {0,-1}, {0,1}}; //상 하 좌 우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        time = new int[R][C];
        cheese  = new boolean[R][C];
        for(int r = 0; r<R; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<C; c++) {
                if(Integer.parseInt(st.nextToken()) == 1) {
                    cheese[r][c] = true;
                }
            }
        }
        goStage();
        System.out.println(hour);
        System.out.println(lastCheese(hour));
    }

    public static void isMelt() { //공기만 탐색하도록 한다. 치즈를 만나면 다음에 녹을 치즈로 체크
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0,0});
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            checked[now[0]][now[1]] = true;
            int x = now[0];
            int y = now[1];
            for(int i=0; i<4; i++) {
                int nx = x + delta[i][0];
                int ny = y + delta[i][1];
                if(nx>=0 && nx<R && ny>=0 && ny<C && !checked[nx][ny]) {
                    if(!cheese[nx][ny]) {
                        queue.add(new int[] {nx,ny});
                    }
                    else
                        melt[nx][ny] = true;
                    checked[nx][ny] = true;
                }
            }
        }
    }

    public static void goStage() {
        while(upStage()) { //치즈가 남아있다면
            hour++; //시간을 늘리고
            checked = new boolean[R][C];
            melt = new boolean[R][C];
            isMelt(); //녹을 치즈 탐색
            for(int i=0; i<R; i++) {
                for(int j=0; j<C; j++) {
                    if(melt[i][j]) { //공기와 닿아있는 치즈를
                        time[i][j] = hour; //그 시간으로 설정
                    }
                }
            }

            for(int i=0; i<R; i++) {
                for(int j=0; j<C; j++) {
                    if(time[i][j] == hour) { //그 시간대의 치즈들은
                        cheese[i][j] = false; //녹았으니 없애준다.
                    }
                }
            }
        }
    }

    public static boolean upStage() { //치즈가 남아있는지 확인
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(cheese[i][j] == true) {
                    return true; //한번 더 진행
                }
            }
        }
        return false;
    }

    public static int lastCheese(int num) { //마지막까지 남아있던 치즈 수 확인
        int cnt = 0;
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(time[i][j] == num) { //마지막 시간대였다면
                    cnt++; //갯수 증가
                }
            }
        }
        return cnt;
    }

}
