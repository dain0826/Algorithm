package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_1861 {
    static int N,M;
    static int[][] room;
    static int r_idx; //출발해야 하는 방 번호
    static int max; //최대 몇개의 방을 이동할 수 있는지
    static int delta[][] = {{-1,0},{1,0},{0,-1},{0,1}}; //상하좌우 이동
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            max = 0;
            r_idx = 0;
            N = Integer.parseInt(br.readLine());
            room = new int[N][N];
            for(int r=0; r<N; r++) {
                st = new StringTokenizer(br.readLine());
                for(int c=0; c<N; c++) {
                    room[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    move(i,j,1);
                }
            }
            System.out.println("#" + t + " " + r_idx + " " + max);

        }

    }
    public static int move(int x, int y, int cnt) {
        for(int i=0; i<4; i++) {
            int nx = x + delta[i][0];
            int ny = y + delta[i][1];

            if(nx>=0 && ny>=0 && nx<N && ny<N && (room[nx][ny] == (room[x][y]+1))) {
                cnt = move(nx,ny,cnt+1);
            }
            else continue;
            if(max < cnt) {
                max = cnt;
                r_idx = room[x][y];
            }
            else if(max == cnt) {
                r_idx =Math.min(r_idx, room[x][y]);
            }
        }
        return cnt;
    }

}

