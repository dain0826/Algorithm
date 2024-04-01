package Recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class R_5656 {

    static int N,W,H;
    static int[][] map, copyMap;
    static int[] biz; // 구슬 떨어트릴 위치
    static int totalBiz; // 처음 벽돌의 개수
    static int answer;
    static int count; // 한 경우에서 사라지는 벽돌 갯수
    static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            map = new int[H][W]; // 벽돌 정보

            totalBiz = 0;
            answer = 0;
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    int n = Integer.parseInt(st.nextToken());
                    if(n != 0) {
                        map[i][j] = n;
                        totalBiz++;
                    }
                }
            }

            biz = new int[N];
            choice(0);
            System.out.println("#" + t + " " + (totalBiz-answer));
        }

    }
    public static void choice(int idx) { // 구슬을 떨어트릴 위치 구하기
        if(idx == N) { // N개의 구슬이 다 정해졌다면
            hit(); // 구슬 쏘기
            return;
        }
        for (int i = 0; i < W; i++) {
            biz[idx] = i;
            choice(idx + 1);
        }
    }

    public static void hit() { // 구슬 쏘는 메서드
        copyMap = new int[H][W];
        for (int i = 0; i < H; i++) {
            for(int j = 0; j<W; j++) {
                copyMap[i][j] = map[i][j];
            }
        }
        count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < H; j++) {
                if(copyMap[j][biz[i]] != 0) { //제일 상단에 위치한 벽돌
                    bomb(j, biz[i]);
                    break;
                }
            }
            drop(); // 벽돌 빈칸 채우기
        }

        answer = Math.max(answer, count);
    }

    public static void bomb(int x, int y) { //다른 벽돌 깨트리는 메서드
        count++;
        int temp = copyMap[x][y]; //해당 벽돌의 범위 저장
        copyMap[x][y] = 0; // 그벽돌은 부숴준다.
        for (int i = 0; i < 4; i++) {
            int nx = x;
            int ny = y;
            for (int j = 1; j < temp; j++) { //범위만큼
                nx += delta[i][0];
                ny += delta[i][1];
                if(nx >= 0 && nx < H && ny >= 0 && ny < W && copyMap[nx][ny] != 0) { // 범위 내에 있고, 벽돌이라면
                    bomb(nx, ny);
                }
            }
        }
    }

    public static void drop() { // 사라진 자리 채우는 메서드
        for (int i = H - 2; i >= 0; i--) {
            for (int j = 0; j < W; j++) {
                if(copyMap[i][j] != 0 && copyMap[i + 1][j] == 0) { //현재 위치가 벽돌이고, 그 밑에가 비어있다면
                    int temp = i;
                    for (int k = i + 1; k < H; k++) { //비어있지 않을 때까지 밑으로 내려간다
                        if(copyMap[k][j] != 0) break; // 벽돌이면
                        else temp = k;
                    }
                    copyMap[temp][j] = copyMap[i][j];
                    copyMap[i][j] = 0;
                }

            }
        }
    }
}
