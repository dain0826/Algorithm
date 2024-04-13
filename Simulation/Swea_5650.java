package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_5650{
    static int T, N;
    static int Max;
    static int[][] map, warmH;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1}; //상, 우, 하, 좌 순서

    static class Ball{
        int r, c;
        int dir;
        int count;

        Ball(int r, int c, int dir){
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <=T; t++) {

            N = Integer.parseInt(br.readLine().trim());
            map = new int[N+2][N+2];
            warmH = new int[11][4]; //실제 사용은 6~10번만 함
            Max = Integer.MIN_VALUE;
            for (int r = 1; r < N+1; r++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int c = 1; c < N+1; c++) {
                    map[r][c]=Integer.parseInt(st.nextToken());
                    if(map[r][c] > 5){// 웜홀에 해당하면 별도로 기록
                        int num = map[r][c];
                        if(warmH[num][0] == 0 && warmH[num][1] == 0){
                            warmH[num][0] = r;
                            warmH[num][1] = c;
                        }else{
                            warmH[num][2] = r;
                            warmH[num][3] = c;
                        }
                    }
                }
            }

            //경계 부분 모두 벽(5)을 셋팅
            for(int i = 0; i < N+1; i++){
                map[i][0] = 5;
                map[0][i] = 5;
                map[N+1][i] = 5;
                map[i][N+1] = 5;
            }


            //--------INPUT END----------------

            //공을 빈 공간에 놔서 보내보기
            for(int r = 1; r < N+1; r++){
                for(int c = 1; c< N+1; c++){
                    if(map[r][c] == 0){
                        map[r][c] = -1; //블랙홀하고 같은 역할이므로 블랙홀로 표기
                        //핀볼게임 시작
                        move(r,c);
                        map[r][c] = 0; // 다른 위치로 가기위해 원상복귀
                    }
                }
            }
            System.out.println("#"+t+" "+Max);
        }
    }

    /*
     * 핀볼 게임 돌리는 메서드
     * */

    private static void move(int r, int c) {
        //공을 4방향 중 어느 방향으로 굴릴지 결정
        for(int d = 0; d < 4; d++){
            Ball b = new Ball(r,c,d);
            while(true){
                //무언가 만나지 않으면 계속 동일한 방향으로 진행
                while(true){
                    b.r += dr[b.dir];
                    b.c += dc[b.dir];

                    if(map[b.r][b.c] != 0){
                        break;
                    }
                }
                //0이 아닌 것들을 만났을때 처리할 내용들
                //1. 블랙홀을 만났을 때(출발지 포함)
                if(map[b.r][b.c] == -1){
                    //점수 갱신 필수
                    Max = Math.max(Max,b.count);
                    break; //게임 끝내기
                }else if(map[b.r][b.c] > 5){//2. 웜홀을 만났을 때 (방향 바꾸지X, 위치만 이동)
                    int num = map[b.r][b.c]; //웜홀 번호 뽑기
                    //만난 웜홀의 위치 찾기
                    if(warmH[num][0] == b.r && warmH[num][1] == b.c){
                        b.r = warmH[num][2];
                        b.c = warmH[num][3];
                    }else{
                        b.r = warmH[num][0];
                        b.c = warmH[num][1];
                    }
                }else if(map[b.r][b.c] <= 5){//3. 블록을 만났을때 (블록 번호에 따라서 방향 바꿈, 점수 올려주기)
                    b.dir = changeDir(map[b.r][b.c], b.dir); // 방향 변경
                    b.count++; //점수 올려주기
                }
            }
        }
    }

    private static int changeDir(int wall, int dir) {
        if(wall == 1){
            if(dir == 0){
                return 2;
            }else if(dir == 1){
                return 3;
            }else if(dir == 2){
                return 1;
            }else{
                return 0;
            }
        }else if(wall == 2){
            if(dir == 0){
                return 1;
            }else if(dir == 1){
                return 3;
            }else if(dir == 2){
                return 0;
            }else{
                return 2;
            }
        }else if(wall == 3){
            if(dir == 0){
                return 3;
            }else if(dir == 1){
                return 2;
            }else if(dir == 2){
                return 0;
            }else{
                return 1;
            }
        }else if(wall == 4){
            if(dir == 0){
                return 2;
            }else if(dir == 1){
                return 0;
            }else if(dir == 2){
                return 3;
            }else{
                return 1;
            }
        }else {
            if(dir == 0){
                return 2;
            }else if(dir == 1){
                return 3;
            }else if(dir == 2){
                return 0;
            }else{
                return 1;
            }
        }
    }
}