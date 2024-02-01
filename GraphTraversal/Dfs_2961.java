package GraphTraversal;

import java.util.Scanner;

public class Dfs_2961 {
    static int[][] taste;
    static int N;
    static int min;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt(); //재료의 개수
        taste = new int[N][2]; //재료의 신맛과 쓴맛을 담을 배열

        for(int i=0; i<N; i++) {
            taste[i][0]= scan.nextInt();
            taste[i][1]= scan.nextInt();
        }
        min = Integer.MAX_VALUE;

        dfs(0, 1, 0, 0);
        System.out.println(min);

    }
    static void dfs(int cur, int sour, int bitter, int cnt) {
        if(cur == N) {//재료를 다 돌았다면
            if(cnt !=0) { //재료를 하나 이상 선택했다면
                min =  Math.min(Math.abs(sour-bitter), min); //최솟값 비교
            }
            return;
        }
        dfs(cur+1, sour*taste[cur][0], bitter+taste[cur][1], cnt+1); //선택
        dfs(cur+1, sour, bitter, cnt); //선택하지 않음
    }
}
