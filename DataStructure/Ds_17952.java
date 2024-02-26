package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Ds_17952{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        Stack<int[]> stack = new Stack<>();

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int job = Integer.parseInt(st.nextToken());
            if(job == 1) {
                int score = Integer.parseInt(st.nextToken());
                int minute = Integer.parseInt(st.nextToken());
                if(minute == 1) { //소요시간이 1분이면 바로 끝낼 수 있음
                    answer += score;
                }
                else {
                    stack.push(new int[] {score,minute-1});
                }
            }
            else if(job == 0) { //추가되는 일이 없다면
                if(!stack.isEmpty()) {
                    stack.peek()[1] -= 1;
                    if(stack.peek()[1] == 0){
                        answer += stack.pop()[0];
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
