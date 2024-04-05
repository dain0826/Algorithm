package GraphTraversal;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Swea_4008{
    static int N;
    static int[] op; //연산자 카드별 갯수를 담을 배열
    static int[] num; //숫자판
    static List<Integer> nowOp;
    static int max,min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            N = Integer.parseInt(br.readLine());
            op = new int[4];
            num = new int[N];
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            nowOp = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<4; i++) {
                op[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0);
            System.out.println("#" + t + " " + Math.abs(max-min));
        }
    }

    public static void dfs(int cnt) {
        if(cnt == N-1) { //연산자개수는 N-1이니까
            int result = num[0];
            for(int i=0; i<nowOp.size(); i++) {
                int op = nowOp.get(i);
                if(op == 0) {
                    result = result + num[i+1];
                }
                else if(op == 1) {
                    result = result - num[i+1];
                }
                else if(op == 2) {
                    result = result * num[i+1];
                }
                else {
                    result = result / num[i+1];
                }
            }
            min = Math.min(min, result);
            max = Math.max(max, result);
            return;
        }
        for(int i=0; i<4; i++) {
            if(op[i] == 0) continue;
            op[i]--;
            nowOp.add(i);
            dfs(cnt+1);
            nowOp.remove(nowOp.size()-1);
            op[i]++;
        }

    }

}
