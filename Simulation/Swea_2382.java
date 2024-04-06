package Simulation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Swea_2382{
    static class Micro implements Comparable<Micro>{
        int x,y,cnt,dir; //1상 2하 3좌 4우

        public Micro(int x, int y, int cnt, int dir) {
            this.x=x;
            this.y=y;
            this.cnt=cnt;
            this.dir=dir;
        }

        @Override
        public int compareTo(Micro o) {
            if(this.x == o.x && this.y == o.y){ //위치가 같다면
               return o.cnt-this.cnt; //미생물 수가 더 많은 순으로 정렬
            }else{
                return (this.x*N+this.y)-(o.x*N+o.y); // 그외에는 좌표 순서대로 정렬
            }
        }
    }
    static int N,M,K;
    static List<Micro> micros;
    static int[][] delta = {{0,0},{-1,0},{1,0},{0,-1},{0,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); //셀의 개수
            M = Integer.parseInt(st.nextToken()); //격리시간
            K = Integer.parseInt(st.nextToken()); //미생물 군집 개수
            micros = new ArrayList<>();
            for(int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                micros.add(new Micro(a,b,c,d));
            }
            int time = 0;
            while(time<M) {
                time++;
                move();
            }
            System.out.println("#" + t + " " + restMicroNum());
        }

    }
    public static void move() {
        for(int i=0; i<micros.size(); i++) {
            micros.get(i).x += delta[micros.get(i).dir][0];
            micros.get(i).y += delta[micros.get(i).dir][1];
            if(checkDrug(micros.get(i).x,micros.get(i).y)) { //약품이 칠해진 셀에 도착하면
                micros.get(i).cnt /= 2;
                if (micros.get(i).dir == 1 || micros.get(i).dir == 3) {
                    micros.get(i).dir += 1;
                } else {
                    micros.get(i).dir -= 1;
                }
                if(micros.get(i).cnt == 0){
                    micros.remove(i);
                    i--;
                }
            }
        }
        Collections.sort(micros);
        for(int i=0;i<micros.size()-1;i++) {
            if(micros.get(i).x==micros.get(i+1).x && micros.get(i).y == micros.get(i+1).y){
                micros.get(i).cnt += micros.get(i+1).cnt;
                micros.remove(i+1);
                i--;
            }
        }
    }
    public static boolean checkDrug(int x, int y) {
        if(x==0  || x==N-1 || y==0 || y==N-1) {
            return true;
        }
        return false;

    }
    public static int restMicroNum() {
        int sum = 0;
        for(int i=0; i<micros.size(); i++) {
            sum += micros.get(i).cnt;
        }
        return sum;
    }

}

