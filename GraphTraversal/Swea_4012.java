package GraphTraversal;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_4012 {
    static int N, answer;
    static int[][] synergy; //식재료간 시너지를 담을 배열
    static boolean[] used; //식재료로 사용했는지 확인

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            //input
            N = Integer.parseInt(br.readLine());
            synergy = new int[N][N];
            used = new boolean[N];
            answer = Integer.MAX_VALUE;

            for(int i=0; i<N; i++) {
                StringTokenizer tk = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    synergy[i][j] = Integer.parseInt(tk.nextToken());
                }
            }
            cook(0, 0);
            sb.append("#" + t + " " + answer + "\n");
        }
        System.out.println(sb);
    }
    static void cook(int cnt, int idx) {
        if(cnt == N / 2) {	//식재료 개수의 절반이면
            int a = 0, b = 0;
            for(int i = 0; i < N; i++) {
                for(int j = i + 1; j < N; j++){
                    if(used[i] && used[j]) { //두 식재료가 한쪽 조합에 들어갔으면
                        a += synergy[i][j] + synergy[j][i]; // 시너지 계신
                    } else if(!used[i] && !used[j]) { //나머지 조합이면
                        b += synergy[i][j] + synergy[j][i]; // 반대쪽 시너지 계산
                    }
                }
            } // end for i
            answer = Math.min(answer, Math.abs(a - b));
            return;
        }
        for(int i = idx; i < N; i++) {
            used[i] = true; //식재료로 사용했다고 업데이트
            cook(cnt+1, i+1);  // 다음 식재료 탐색
            used[i] = false; // 사용하지 않았다고 업데이트
        }
    }
}