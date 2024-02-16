package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_1873{
    static char[][] map;
    static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}}; //방향 : 상,하,좌,우
    static int dir;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            System.out.print("#" + t + " ");
            dir = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            map = new char[H][W];
            int x = 0;
            int y = 0;
            int nx = 0;
            int ny = 0;
            for(int i=0; i<H; i++) {
                String line = br.readLine();
                for(int j=0; j<W; j++){
                    map[i][j] = line.charAt(j);
                    if(map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>'){
                        if (map[i][j] == '^') {
                            dir = 0;
                        } else if (map[i][j] == 'v') {
                            dir = 1;
                        } else if (map[i][j] == '<') {
                            dir = 2;
                        } else if (map[i][j] == '>') {
                            dir = 3;
                        }
                        x = i;
                        y = j;
                    }
                }
            }
            int N = Integer.parseInt(br.readLine());
            String tmp = br.readLine();
            for(int i=0; i<N; i++){
                char input = tmp.charAt(i);
                if(input == 'S'){ //포탄 발사
                    int c = 1;
                    while(true){
                        nx = x + delta[dir][0]*c;
                        ny = y + delta[dir][1]*c;
                        if(nx<0 || ny<0 || nx>= H || ny >= W){
                            break;
                        }
                        if(map[nx][ny] == '#'){ //강철로 만들어진 벽을 만나면
                            break; //포탄 소멸
                        }
                        if(map[nx][ny] == '*'){ //벽돌로 만들어진 벽을 만나면
                            map[nx][ny] = '.'; //그 칸은 평지가 된다
                            break;
                        }
                        c++; //직진
                    }
                }
                else{
                    change(x,y,input);
                    nx = x + delta[dir][0];
                    ny = y + delta[dir][1];
                    if(nx<0 || ny<0 || nx>= H || ny >= W){
                        continue;
                    }
                    if(map[nx][ny] == '.'){ //평지, 전차가 들어갈 수 있다면
                        map[nx][ny] = map[x][y];
                        map[x][y] = '.';
                        x = nx;
                        y = ny;
                    }
                }
            }

            for(int i=0; i<H; i++){
                for(int j=0; j<W; j++){
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
    }
    public static void change(int x, int y, char c){ //현재 위치에서 방향 바꾸기
        if(c == 'U'){ //Up
            map[x][y] = '^';
            dir = 0;
        }
        else if(c == 'D'){ //Down
            map[x][y] = 'v';
            dir = 1;
        }
        else if(c == 'L'){ //Left
            map[x][y] = '<';
            dir = 2;
        }
        else if(c == 'R'){ //Right
            map[x][y] = '>';
            dir =3 ;
        }
    }
}