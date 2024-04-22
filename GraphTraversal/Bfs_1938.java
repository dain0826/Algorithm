package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Bfs_1938 {
    static int N, answer, dr;
    static int[][] train, dest;
    static int[][] map;
    static boolean[][][] visited;
    static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1},{0,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        train = new int[3][2];
        dest = new int[3][2];
        map = new int[N][N];
        visited = new boolean[N][N][2];
        answer = Integer.MAX_VALUE;
        int cnt = 0;
        int cnt1 = 0;
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<N; j++) {
                if(s.charAt(j) == 'B') {
                    train[cnt][0] = i;
                    train[cnt][1] = j;
                    cnt++;
                }
                else if(s.charAt(j) == '1'){
                    map[i][j] = 1;
                }
                else if(s.charAt(j) == 'E') {
                    dest[cnt1][0] = i;
                    dest[cnt1][1] = j;
                    cnt1++;
                }
            }
        }
        dr = rotate(dest);
        bfs();
        if(answer == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(answer);

    }
    public static int rotate(int[][] arr){ //기차의 방향 알아내는 함수
        if(arr[0][0] == arr[1][0]) return 0; //같은 행에 있다면 가로방향
        else return 1; //같은 열에 있다면 세로방향
    }
    public static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {train[1][0], train[1][1], 0, rotate(train)}); //x좌표, y좌표, move횟수, 회전 방향
        visited[train[1][0]][train[1][1]][rotate(train)] = true;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            if(success(now[0], now[1], now[3])){
                answer = Math.min(answer, now[2]);
                return;
            }
            for(int i=0; i<5; i++) {
                int nx = now[0] + delta[i][0];
                int ny = now[1] + delta[i][1];
                if(canMove(nx,ny,i,now[3])){
                    if(i == 4){
                        visited[nx][ny][1-now[3]] = true;
                        queue.add(new int[] {nx,ny, now[2]+1, 1-now[3]});
                    }
                    else {
                        visited[nx][ny][now[3]] = true;
                        queue.add(new int[] {nx,ny,now[2]+1, now[3]});
                    }
                }
            }
        }
    }
    public static boolean success(int x, int y, int r) {
        if(r==0 && dr == 0 && y-1==dest[0][1] && y==dest[1][1] && y+1==dest[2][1] && x==dest[1][0]) return true;
        if(r==1 && dr == 1 && x-1==dest[0][0] && x==dest[1][0] && x+1==dest[2][0] && y==dest[1][1]) return true;
        return false;
    }
    public static boolean canMove(int x, int y, int d, int r){
        int x1 = 0;
        int x2 = 0;
        int x3 = 0;
        int y1 = 0;
        int y2 = 0;
        int y3 = 0;
        if(r==0){
            x1 = x;
            x2 = x;
            x3 = x;
            y1 = y-1;
            y2 = y;
            y3 = y+1;
        }
        else if(r==1){
            x1 = x-1;
            x2 = x;
            x3 = x+1;
            y1 = y;
            y2 = y;
            y3 = y;
        }
        if(d==4){
            for(int i=x-1; i<x+2; i++) {
                for(int j=y-1; j<y+2; j++) {
                    if(i<0 || i>=N || j<0|| j>=N || map[i][j] == 1) return false;
                }
            }
            if(visited[x][y][1-r]) return false;
        }
        else if(d==0) { //상
            if(x1<0) return false;
        }
        else if(d==1) { //하
            if(x3>=N) return false;
        }
        else if(d==2) { //좌
            if(y1<0) return false;
        }
        else if(d==3) { //우
            if(y3>=N) return false;
        }
        if(d!=4){
            if(visited[x][y][r]) return false;
            if(map[x1][y1] == 1 || map[x2][y2] == 1 || map[x3][y3] == 1) return false;
        }
        return true;
    }


}