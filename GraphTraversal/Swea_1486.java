package GraphTraversal;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_1486{
    static int N,B;
    static int[] height;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); //N명의 점원
            B = Integer.parseInt(st.nextToken()); //선반의 높이
            height = new int[N]; //점원들의 키를 담는 배열
            answer = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                height[i] = Integer.parseInt(st.nextToken());
            }
            buildTop(0,0);
            System.out.println("#" + t  +" " + Math.abs(answer-B));
        }

    }
    public static void buildTop(int idx, int sum) {
        if(idx==N) {
            if(sum>=B) {
                answer = Math.min(answer, sum);
            }
            return;
        }
        buildTop(idx+1, sum);
        buildTop(idx+1, sum+height[idx]);
    }

}
