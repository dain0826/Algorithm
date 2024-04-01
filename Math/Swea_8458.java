package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_8458 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            int answer = 0;
            int max = 0;
            int sum = 0;
            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i] = Math.abs(Integer.parseInt(st.nextToken())) + Math.abs(Integer.parseInt(st.nextToken()));
                max = Math.max(arr[i], max);
            }

            for(int i=1; i<N; i++){
                if(arr[0]%2 != arr[i]%2){
                    answer = -1;
                    break;
                }
            }
            if(answer!= -1) {
                for(int i=0; ;i++) {
                    sum += i;
                    if(sum >= max && sum%2==max%2) {
                        answer = i;
                        break;
                    }
                }
            }
            System.out.println("#" + t + " " + answer);
        }

    }

}
