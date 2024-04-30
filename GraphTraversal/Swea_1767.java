package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Swea_1767{
    static class Core{
        int x, y;

        public Core(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }
    static int N;
    static int max, min;
    static int[][] map;
    static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
    static ArrayList<Core> cores;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine().trim());
        for(int t = 1; t<=T; t++) {
            N = Integer.parseInt(br.readLine().trim());
            cores = new ArrayList<>();
            map = new int[N][N];
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine().trim());
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] == 1) {
                        if(i!=0 &&i!=N-1&&j!=0&&j!=N-1) {
                            cores.add(new Core(i,j));
                        }
                    }
                }
            }
            setLine(0,0,0);
            System.out.println("#" + t + " " + min);
        }
    }
    public static void setLine(int idx, int cnt, int len) {
        if(idx == cores.size()) {
            if(max<cnt) {
                max = cnt;
                min = len;
            }
            else if(max==cnt) {
                min = Math.min(min, len);
            }
            return;
        }
        int x = cores.get(idx).x;
        int y = cores.get(idx).y;
        for(int d=0; d<4; d++) { //4방탐색
            int nx = x;
            int ny = y;
            int line = 0;
            while(true) {
                nx += delta[d][0];
                ny += delta[d][1];
                if(nx<0 || ny<0 || nx>=N ||ny>=N) break;
                if(map[nx][ny] == 1) {
                    line = 0;
                    break;
                }
                line++;
            }
            if(line>0) {
                nx = x;
                ny = y;
                for(int l=0; l<line; l++) {
                    nx += delta[d][0];
                    ny += delta[d][1];
                    map[nx][ny] = 1;
                }
                setLine(idx+1, cnt+1, len+line);
                nx = x;
                ny = y;
                for(int l=0; l<line; l++) {
                    nx += delta[d][0];
                    ny += delta[d][1];
                    map[nx][ny] = 0;
                }
            }
        }
        setLine(idx+1, cnt, len); //미선택
    }
}