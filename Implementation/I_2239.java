package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class I_2239 {
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[9][9];
        for(int i=0; i<9; i++) {
            String s = br.readLine();
            for(int j=0; j<9; j++) {
                board[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }
        int[] start = canGo();
        play(start[0], start[1]);
    }
    public static int[] canGo() {
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(board[i][j] == 0) return new int[] {i,j}; //아직 채워지지 않은 칸이 있다면 해당 칸 반환
            }
        }

        return new int[] {-1,-1}; //다 채워졌다면 -1 반환
    }
    public static void play(int x, int y) {
        if(x==-1) { //다 채워진 보드이므로 출력
            printBoard();
        }
        for(int i=1; i<=9; i++) {
            if(check(x, y, i)) { //숫자를 넣을 수 있다면
                board[x][y] = i; //보드 바꿔주고
                int[] next = canGo();
                play(next[0], next[1]);//또 다른 칸 진행
                board[x][y] = 0; //되돌리기
            }
        }
    }
    public static boolean check(int x, int y, int num) { //x, y좌표 받아서 num(1~9)이 이미 보드에 있는지 확인
        for(int i=0; i<9; i++) {
            if(board[x][i] == num || board[i][y] == num) return false; //가로, 세로
        }
        int gx = x/3 * 3;
        int gy = y/3 * 3;
        for(int i=gx; i<gx+3; i++) { //3*3 그룹 확인
            for(int j=gy; j<gy+3; j++) {
                if(board[i][j] == num) return false;
            }
        }
        return true;
    }
    public static void printBoard() { //보드가 다 채워졌다면 화면에 출력
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.exit(0); //종료
    }
}
