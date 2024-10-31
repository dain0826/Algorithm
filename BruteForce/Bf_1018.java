package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bf_1018 {
    static int N;
    static int M;
    static int answer;
    static boolean[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];
        answer = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < M; j++){
                if(s.charAt(j) == 'W') map[i][j] = true; //흰색
            }
        }
        for(int i = 0; i <= N-8; i++){
            for(int j = 0; j <= M-8; j++){
                checkBoard(i,j);
            }
        }
        System.out.println(answer);

    }
    private static void checkBoard(int i, int j){
        int count = 0;
        boolean flag = map[i][j];//첫번째 칸의 색상
        for(int k = i; k < i+8; k++){
            for(int l = j; l < j+8; l++){
                if(map[k][l]!=flag){
                    count++;
                }
                flag = !flag;
            }
            flag = !flag;
        }
        count = Math.min(count, 64-count);
        answer = Math.min(answer, count);
    }
}