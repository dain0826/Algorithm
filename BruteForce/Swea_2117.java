package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Swea_2117 {

    static int N,M, answer;
    static int[][] map;
    static int fee;
    static class Home{
        int x, y;
        public Home(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static List<Home> house;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            house = new ArrayList<>();
            map = new int[N][N];
            answer = 0;
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] == 1){
                        house.add(new Home(i,j));
                    }
                }
            }

            for(int n=N+1; n>=1; n--){
                fee = n*n + (n-1)*(n-1);//운영 영역의 크기 1부터 N+1까지 다 시도해본다.
                for(int i=0; i<N; i++){
                    for(int j=0; j<N; j++){
                       service(i,j,n);
                    }
                }
            }
            System.out.println("#" + t + " " + answer);
        }

    }

    public static void service(int x, int y, int d){
        int count = 0;
        for(int i=0; i<house.size(); i++){
            int hx = house.get(i).x;
            int hy = house.get(i).y;
            int distance = Math.abs(x-hx)+Math.abs(y-hy)+1;
            if(distance<=d) count++;
        }
        if(count*M - fee >=0) {
            answer = Math.max(answer, count);
        }
    }

}
