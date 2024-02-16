package GraphTraversal;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dfs_1987{
    static int R, C, answer;
    static char[][] board;
    static boolean[] alp = new boolean[26];
    static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}}; //상하좌우로 이동
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];

        for(int i=0; i<R; i++) {
            String line = br.readLine();
            for(int j=0; j<C; j++) {
                board[i][j] = line.charAt(j);
            }
        }
        alp[board[0][0]-65] = true;
        move(0,0,1);
        System.out.println(answer);
    }
    public static void move(int x, int y, int cnt) {
        answer = Math.max(cnt,answer);
        for(int i=0; i<4; i++) {
            int nx = x + delta[i][0];
            int ny = y + delta[i][1];
            if(nx>=0 && ny>=0 && nx<R && ny<C) {
                if(!alp[(board[nx][ny]-65)]) {
                    alp[board[nx][ny] - 65] = true;
                    move(nx,ny,cnt+1);
                    alp[board[nx][ny] - 65] = false;
                }
            }
        }
    }
}
