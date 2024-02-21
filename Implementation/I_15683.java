package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class I_15683 {
    static class CCTV{
        int x;
        int y;
        int type;

        CCTV(int x, int y, int type){
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
    static int N,M;
    static int answer = Integer.MAX_VALUE;
    static int[][] room, copyRoom;
    static int[] direction; //cctv 각각의 회전방향을 담는 배열
    static int[][] delta = {{-1,0},{0,1},{1,0},{0,-1}}; //위, 오른쪽, 아래, 왼쪽
    static List<CCTV> cctvs= new LinkedList<CCTV>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        room = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if(room[i][j]>=1 && room[i][j]<=5) {
                    cctvs.add(new CCTV(i,j,room[i][j]));
                }
            }
        }
        direction = new int[cctvs.size()];
        dfs(0);
        System.out.println(answer);
    }

    public static void dfs(int cnt) {
        if(cnt == cctvs.size()) { //모든 cctv의 회전방향을 결정했다면
            copy(); //배열 복사해서 사무실 하나 더 만들어준다.
            for(int i=0; i<cctvs.size(); i++) {
                int d = direction[i];
                turnCCTV(cctvs.get(i), d);
            }
            checkSpace(); //사각지대 개수 체크
        }
        else {
            for(int i=0; i<4; i++) {
                direction[cnt] = i; //모든 회전방향 한번씩 담아주기
                dfs(cnt+1);
            }
        }

    }

    public static void turnCCTV(CCTV cctv, int d) { //cctv 번호에따른 모니터 방향 결정
        if(cctv.type == 1) { //1번 cctv는 한방향만 비춘다.
            monitor(cctv, d);
        }
        else if(cctv.type == 2) { //2번 cctv는 위아래 / 우,좌 이렇게 두방향을 비출 수 있다.
            if(d == 0 || d == 2) {
                monitor(cctv, 0);
                monitor(cctv, 2);
            }
            else {
                monitor(cctv, 1);
                monitor(cctv, 3);
            }
        }
        else if(cctv.type == 3) { //3번 cctv는 방향을 연달아서 비춘다
            if(d==3) {
                monitor(cctv, 3);
                monitor(cctv, 0);
            }
            else {
                monitor(cctv, d);
                monitor(cctv, d+1);
            }
        }
        else if(cctv.type == 4) { //4번 cctv는 한방향 빼고 다 비춘다.
            if(d == 0) {
                monitor(cctv,0);
                monitor(cctv,1);
                monitor(cctv,3);
            }
            else if(d==1) {
                monitor(cctv, 0);
                monitor(cctv, 1);
                monitor(cctv, 2);
            }
            else if(d==2) {
                monitor(cctv, 1);
                monitor(cctv, 2);
                monitor(cctv, 3);
            }
            else if(d==3) {
                monitor(cctv, 2);
                monitor(cctv, 3);
                monitor(cctv, 0);
            }
        }
        else if(cctv.type == 5) { //5번 cctv는 모든 방향을 비춘다.
            monitor(cctv,0);
            monitor(cctv,1);
            monitor(cctv,2);
            monitor(cctv,3);
        }
    }

    public static void monitor(CCTV c, int d) {
        int nx = c.x + delta[d][0]; //다음 좌표 설정
        int ny = c.y + delta[d][1];
        while(nx>=0 && ny>=0 && nx<N && ny<M && copyRoom[nx][ny]!=6) { //좌표 내에 있고 벽이 아니면
            copyRoom[nx][ny] = -1; //cctv가 감시할 수 있는 공간이니-1로 설정
            nx += delta[d][0];
            ny += delta[d][1];
        }
    }

    public static void copy() { //원본 배열 복사
        copyRoom = new int[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                copyRoom[i][j] = room[i][j];
            }
        }
    }

    public static void checkSpace() { //사각지대 갯수 확인
        int sum = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(copyRoom[i][j] == 0) { //배열에 cctv가 닿는 곳은 -1, 벽은 6으로 되어 있으니까
                    sum++;
                }
            }
        }
        answer = Math.min(answer, sum); //answer값 업데이트
    }

}
