package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class I_20361 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //종이컵의 수
        int X = Integer.parseInt(st.nextToken()); //간식이 들어있는 종이컵이 왼쪽에서 몇번째에 있는지
        int K = Integer.parseInt(st.nextToken()); // 컵의 위치를 맞바꾸는 횟수
        int answer = 0; //간식이 위치한 종이컵의 위치
        boolean[] cups = new boolean[N+1]; //인덱스 1부터 시작하기 위해 +1
        cups[X] = true; //처음 간식이 들어있던 종이컵의 boolean값 true
        for(int k=0; k<K; k++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            boolean temp = false;
            temp = cups[a]; //a,b 종이컵 교환
            cups[a] = cups[b];
            cups[b] = temp;
        }
        for(int i=1; i<=N; i++) {
            if(cups[i]) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);

    }

}
