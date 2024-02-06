package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_9229 {
    static int N,M;
    static int[] snack; //과자 각각의 무게를 담을 배열
    static int max;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for(int i=1; i<= tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 과자 봉지의 개수
            M = Integer.parseInt(st.nextToken()); //무게 제한
            snack = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                snack[j] = Integer.parseInt(st.nextToken());
            }
            max=-1;
            choice(0,0,0);
            sb.append("#" + i + " " + max + "\n");
        }
        System.out.println(sb);
    }

    public static void choice(int idx, int weight, int depth) {
        if(weight > M) { //제한 무게를 넘으면 리턴
            return;
        }
        if(depth == 2) { //과자봉지수가 2가 되면
            max = Math.max(max, weight); //max값 업데이트
            return;
        }
        if(idx == N) { //과자 배열을 다 돌았으면 리턴
            return;
        }
        choice(idx+1, weight + snack[idx], depth+1); //지금 과자를 선택
        choice(idx+1, weight, depth); //지금 과자를 선택하지 않음
    }
}
