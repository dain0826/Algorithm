package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dfs_3109 {
    static int R, C;
    static int[][] delta = {{-1,1}, {0,1}, {1,1}}; //오른쪽 위, 오른쪽, 오른쪽 아래로 이동
    static boolean[][] pipe;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        pipe = new boolean[R][C];

        for(int r=0; r<R; r++){
            String line = br.readLine();
            for(int c=0; c<C; c++) {
                if(line.charAt(c) =='.'){ // "." 이면 이동할 수 있으므로 true
                    pipe[r][c] = true;
                }
            }
        }
        int answer = 0;
        for(int i=0; i<R; i++){
            if(build(i,0)) {
                answer++;
            }
        }
        System.out.println(answer);
    }
    static boolean build(int x, int y){
        pipe[x][y] = false; //이미 이동해본 경로는 false로 처리해준다
        if(y == C-1){ //마지막 열에 도착했다면 파이프를 설치할 수 있다
            return true;
        }
        for(int i=0; i<3; i++) {
            int nx = x + delta[i][0];
            int ny = y + delta[i][1];
            if (nx < 0 || ny < 0 || nx >= R || ny >= C || !pipe[nx][ny]) continue;
            if (build(nx, ny)) {
                return true;
            }
        }
        return false;
    }
}
