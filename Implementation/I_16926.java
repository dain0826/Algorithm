package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class I_16926 {
    static int[][] delta = {{0,1},{1,0}, {0,-1}, {-1,0}}; //하, 우, 상, 좌
    static int N,M,R; //배열의 크기 N, M 회전수 R
    static int[][] arr; //[N][M] 크기의 배열
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for(int i=0; i<N; i++) { //주어진 배열 입력받기
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int r=0; r<R; r++) { //R만큼 회전시키기
            turn();
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
    public static void turn() { //반시계방향으로 회전시키는 메서드
        for(int i=0; i<Math.min(N,M)/2; i++) {
            int temp = arr[i][i];
            int x = i;
            int y = i;
            int dir = 0;
            while(dir < 4){
                int nx = x + delta[dir][0];
                int ny = y + delta[dir][1];
                if(nx< N-i && ny < M-i && nx >= i && ny >= i){
                    arr[x][y] = arr[nx][ny];
                    x = nx;
                    y = ny;
                }
                else dir++;
            }
            arr[i+1][i] = temp;
        }
    }
}
