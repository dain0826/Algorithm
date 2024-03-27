package DynamicProgramming;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_3307 {
    static int N, answer;
    static int[] num;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            answer  = 1;
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            num = new int[N];
            dp = new int[N];
            for(int i=0; i<N; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }

            dp[0] = 1;
            for(int i=1; i<N; i++) {
                dp[i] = 1;
                for(int j=0; j<i; j++) {
                    if(num[j] < num[i]) {
                        dp[i] = Math.max(dp[i], dp[j]+1);
                    }
                }
                answer = Math.max(answer, dp[i]);
            }

            System.out.println("#" + t + " " + answer);
        }

    }

}
