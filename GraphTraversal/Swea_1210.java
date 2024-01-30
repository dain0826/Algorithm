package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_1210 {
    static int[][] ladder;
    static int answer;
    static int[][] delta = {{0,-1},{0,1},{-1,0}}; //좌, 우, 상 으로 이동 가능, 문제에서 행 열이 반대로 나와있다
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int t=1; t<= 10; t++) {
            int test = Integer.parseInt(br.readLine());
            ladder = new int[100][100];
            int tX = 0;
            int tY= 0;
            for(int i = 0; i<100; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<100; j++) {
                    ladder[i][j]= Integer.parseInt(st.nextToken());
                    if(ladder[i][j] == 2) { //값이 2인 곳이 도착지
                        tX = i;
                        tY = j;
                    }
                }
            }
            move(tX, tY); //도착지에서 위로 올라감
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    public static void move(int x, int y) {
       while(true){
           if(x==0){ //x=0인 곳이 원래의 출발점
               answer = y;
               break;
           }
           ladder[x][y] = 0;
           for(int i=0; i<3; i++){
               int nx = x + delta[i][0];
               int ny = y + delta[i][1];
               if(nx<0 || nx>=100 || ny<0 || ny>=100 || ladder[nx][ny]==0) continue;
               x = nx;
               y = ny;
           }
       }
    }
}
