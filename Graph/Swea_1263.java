package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_1263{
    static int N;
    static int[][] arr;
    static int[] CC;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            CC = new int[N];
            arr = new int[N][N];
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    arr[i][j] = 1000000000;
                }
            }
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    int temp = Integer.parseInt(st.nextToken());
                    if(temp == 1) arr[i][j] = 1;
                }
            }
            for(int k=0; k<N; k++) {
                for(int i=0; i<N; i++) {
                    for(int j=0; j<N; j++) {
                        arr[i][j] = Math.min(arr[i][j], arr[i][k]+arr[k][j]);
                    }
                }
            }
            answer = Integer.MAX_VALUE;
            for(int i=0;i<N;i++) {
                for(int j=0; j<N; j++) {
                    if(i==j) continue;
                    CC[i] += arr[i][j];
                }
                answer = Math.min(answer, CC[i]);
            }
            System.out.println("#" + t + " " + answer);
        }
    }
}
