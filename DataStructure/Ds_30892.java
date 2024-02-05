package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Ds_30892 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //상어의 마릿수
        int K = Integer.parseInt(st.nextToken()); //먹을 수 있는 최대 마릿수
        int T = Integer.parseInt(st.nextToken()); //최초 크기
        st = new StringTokenizer(br.readLine());

        int[] scale = new int[N];
        for(int i=0; i<N; i++) {
            scale[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(scale); //오름차순으로 정렬

        Stack<Integer> shark = new Stack<Integer>(); //전체 상어를 넣어주기 위한 스택
        Stack<Integer> eat = new Stack<Integer>(); //먹을 수 있는 상어 스택

        for(int i=N-1; i>=0; i--) {
            shark.push(scale[i]); //크기가 큰 상어부터 넣어준다.
        }
        long answer = T; // 샼의 누적 크기
        for(int i=0;i<K; i++) { //최대 K 마리 먹을 수 있으므로
            while(!shark.isEmpty() && answer > shark.peek()) { //상어스택이 공백이 아니고, 제일 상위의 상어가 샼보다 작다면
                eat.push(shark.pop()); //먹을 수 있는 상어 스택에 넣어준다.
            }
            if(!eat.isEmpty()) //먹을 수 있는 상어가 있다면
                answer += eat.pop(); //샼의 몸집을 키워준다.

        }
        System.out.println(answer);
    }
}
