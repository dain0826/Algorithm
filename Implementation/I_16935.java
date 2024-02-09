package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class I_16935 {
    static int N,M,R;
    static int[][] arr;
    static int[][] rotateArr;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<R; i++) {
            int order = Integer.parseInt(st.nextToken());
            switch(order) {
                case 1 :
                    rotate1();
                    break;
                case 2 :
                    rotate2();
                    break;
                case 3:
                    rotate3();
                    break;
                case 4 :
                    rotate4();
                    break;
                case 5 :
                    rotate5();
                    break;
                case 6 :
                    rotate6();
                    break;
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void rotate1() { //상하반전
        rotateArr = new int[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                rotateArr[N-1-i][j] = arr[i][j];
            }
        }
        arr = rotateArr;
    }
    public static void rotate2() { //좌우반전
        rotateArr = new int[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                rotateArr[i][M-1-j] = arr[i][j];
            }
        }
        arr = rotateArr;
    }
    public static void rotate3() { //오른쪽으로 90도 회전
        rotateArr = new int[M][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                rotateArr[j][N-1-i] = arr[i][j];
            }
        }
        int temp = N;
        N = M;
        M = temp;

        arr = rotateArr;
    }
    public static void rotate4() { //왼쪽으로 90도 회전
        rotateArr = new int[M][N];
        for(int i=0; i<N; i++) {
            for (int j = 0; j < M; j++) {
                rotateArr[M-1-j][i] = arr[i][j];
            }
        }
        int temp = N;
        N = M;
        M = temp;

        arr = rotateArr;
    }
    public static void rotate5() { //1번 그룹의 부분 배열을 2번 그룹 위치로, 2번을 3번으로, 3번을 4번으로, 4번을 1번으로 이동시키는 연산
        rotateArr = new int[N][M];
        for(int i=0;i<N/2;i++) {
            for(int j=0;j<M/2;j++) {
                rotateArr[i][M/2+j] = arr[i][j];
            }
        }
        for(int i=0;i<N/2;i++) {
            for(int j=M/2;j<M;j++) {
                rotateArr[N/2+i][j] = arr[i][j];
            }
        }
        for(int i=N/2;i<N;i++) {
            for(int j=M/2;j<M;j++) {
                rotateArr[i][j-M/2] = arr[i][j];
            }
        }
        for(int i=N/2;i<N;i++) {
            for(int j=0;j<M/2; j++) {
                rotateArr[i-N/2][j] = arr[i][j];
            }
        }
        arr = rotateArr;

    }
    public static void rotate6() { //1번 그룹의 부분 배열을 4번 그룹 위치로, 4번을 3번으로, 3번을 2번으로, 2번을 1번으로 이동시키는 연산
        rotateArr = new int[N][M];
        for(int i=0; i<N/2; i++){
            for(int j=0; j<M/2; j++){
                rotateArr[N/2+i][j] = arr[i][j];
            }
        }
        for(int i=N/2; i<N; i++){
            for(int j=0; j<M/2; j++){
                rotateArr[i][j+M/2] = arr[i][j];
            }
        }
        for(int i=N/2; i<N; i++){
            for(int j=M/2; j<M; j++){
                rotateArr[i-N/2][j] = arr[i][j];
            }
        }
        for(int i=0; i<N/2; i++){
            for(int j=M/2; j<M; j++){
                rotateArr[i][j-M/2] = arr[i][j];
            }
        }
        arr = rotateArr;
    }
}