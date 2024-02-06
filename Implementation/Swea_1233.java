package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_1233 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int test_case=1; test_case<=10; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            int num=0;
            int result = 1;
            for(int i=1; i<=cnt; i++) {
                st = new StringTokenizer(br.readLine());
                num = Integer.parseInt(st.nextToken());
                String op = st.nextToken(); //연산자 op
                if(!op.equals("+") && !op.equals("-") && !op.equals("*") && !op.equals("/") && st.hasMoreTokens()) {//연산자 자리에 숫자가 오고 자식 노드가 있다면
                    result = 0; //연산이 불가능하다.
                }
            }
            System.out.println("#" + test_case + " " + result);
        }
    }

}
