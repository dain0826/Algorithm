package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Swea_1767{

    static class Core{
        int x,y;

        public Core(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    static int max, min; //지금까지 연결한 코어의 수, 지금까지 소요된 전선의 수
    static int[][] pro;
    static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}}; //상하좌우로 이동
    static ArrayList<Core> cores;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=T; tc++) {
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            cores = new ArrayList<>();
            pro = new int[N][N];
            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    pro[i][j] = Integer.parseInt(st.nextToken());
                    if(pro[i][j] == 1) { //코어이면
                        if(i!=0 && j!=0 && i!= N-1 && j != N-1) { //가장자리 아닌 코어만
                            cores.add(new Core(i,j)); //코어리스트에 추가
                        }
                    }

                }
            }
            connect(0,0,0);
            System.out.println("#" + tc + " " + min);
        }

    }
    public static void connect(int idx, int cnt, int len) { //현재 코어의 인덱스, 연결한 코어 수, 필요한 전선의 수
        if(idx == cores.size()) {
            if(max<cnt) { //이전보다 더 많은 수의 코어에 연결했다면
                max = cnt; //max값 업데이트
                min = len; //min값 업데이트
            }
            else if(max == cnt) { //동일한 수의 코어에 연결했다면
                if(min>len) { //더 적게 전선을 사용했다면
                    min = len; //min값 업데이트
                }
            }
            return;
        }
        int x = cores.get(idx).x;
        int y = cores.get(idx).y;
        for(int i=0; i<4; i++) { //코어 위치에서 가장자리까지 전선을 뻗어나갈 방향 결정
            int cx = x;
            int cy = y;
            int nx = cx;
            int ny = cy;
            int line = 0;
            while(true) {
                nx += delta[i][0]; //다음에 전선이 놓이는 위치
                ny += delta[i][1];
                if(nx<0|| ny<0 || nx>=N || ny>= N) { //가장자리까지 도달했다면
                    break; //해당 방향으로 진행하던 전선 놓기 끝
                }
                if(pro[nx][ny] == 1) { //전선을 놓을 수 있는 방향이 아니니까
                    line = 0; //지금까지 쓴 전선 갯수 초기화
                    break;
                }
                line++;
            }
            if(line == 0) {
                connect(idx+1, cnt, len+line);
            }
            else {
                for(int l=0; l<line; l++) { //전선 깔기
                    cx += delta[i][0];
                    cy += delta[i][1];
                    pro[cx][cy] = 1; //다른 전선이 못지나가게
                }
                connect(idx+1, cnt+1, len+line);
                cx = x;
                cy = y;
                for(int l=0; l<line; l++) { //전선 없애기
                    cx += delta[i][0];
                    cy += delta[i][1];
                    pro[cx][cy] = 0;
                }
            }
        }

    }

}
