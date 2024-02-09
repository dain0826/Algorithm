package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class I_2563 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //색종이의 수
        int[][] paper = new int[100][100]; //색종이를 담을 배열
        int a=0;
        int b=0;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            for(int j=a; j<a+10; j++) {
                for(int k=b; k<b+10; k++) {
                    paper[j][k] = 1;
                }
            }
        }
        int sum = 0;
        for(int i=0; i<100; i++) {
            for(int j=0; j<100; j++) {
                sum += paper[i][j];
            }
        }
        System.out.println(sum);
    }
}
