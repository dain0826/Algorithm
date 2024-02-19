package Implementation;

import java.util.Scanner;

public class Swea_5644 {
    static int M, A;
    static int[] pathA, pathB, userA, userB;
    static int[][] bc;

    static int[] dx = {0,0,1,0,-1};
    static int[] dy = {0,-1,0,1,0};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        userA = new int[2];
        userB = new int[2];

        for(int tc=1; tc<=T; tc++) {
            M = sc.nextInt(); //이동횟수
            A = sc.nextInt(); //충전기 수

            userA[0] = userA[1] = 1;
            userB[0] = userB[1] = 10;

            pathA = new int[M+1]; //A의 경로
            pathB = new int[M+1]; //B의 경로
            bc = new int[A][4]; //충전기 정보

            for(int i=1; i<M+1; i++) {
                pathA[i] = sc.nextInt();
            }
            for(int i=1; i<M+1; i++) {
                pathB[i] = sc.nextInt();
            }


            for(int i=0; i< A; i++) {
                bc[i][0] = sc.nextInt(); //x
                bc[i][1] = sc.nextInt(); //y
                bc[i][2] = sc.nextInt(); //거리
                bc[i][3] = sc.nextInt(); //충전량

            }

            System.out.println("#"+tc+" "+move());
        }
    }

    private static int move(){
        int totalSum = 0;
        for(int i=0; i<M+1; i++) {
            userA[0] += dx[pathA[i]];
            userA[1] += dy[pathA[i]];
            userB[0] += dx[pathB[i]];
            userB[1] += dy[pathB[i]];

            totalSum += getMaxCharge();
        }
        return totalSum;
    }

    private static int check(int idx, int x, int y) {
        return Math.abs(bc[idx][0]-x)+Math.abs(bc[idx][1]-y) <= bc[idx][2] ? bc[idx][3] : 0;
    }

    private static int getMaxCharge() {
        int max = 0;
        for(int a=0; a<A; a++) {
            for(int b=0; b<A; b++) {
                int sum = 0;
                int amountA = check(a, userA[0], userA[1]);
                int amountB = check(b, userB[0], userB[1]);

                if(a != b)
                    sum = amountA + amountB;
                else
                    sum = Math.max(amountA, amountB);

                if(max < sum)
                    max = sum;
            }
        }
        return max;
    }
}