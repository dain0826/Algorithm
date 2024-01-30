package GraphTraversal;

import java.util.Arrays;
import java.util.Scanner;

public class Dfs_15649 {
    static int N;
    static int M;
    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        M = scan.nextInt();
        arr = new int[M]; //depth별 숫자를 담을 배열
        visited = new boolean[N];
        dfs(0); //dfs 함수 호출, depth는 0부터
        System.out.println(sb);

    }

    public static void dfs(int depth) {
        if(depth == M) { //depth가 m까지 다 왔다면
            for(int i : arr) { //arr에 추가한 숫자들을 다 출력한다
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<N; i++) {
            if(!visited[i]) { //중복체크
                visited[i] = true;
                arr[depth] = i+1; //i가 0부터 시작했으니 i+1을 넣어준다.
                dfs(depth+1); //depth+1해서 다시 함수호출
                visited[i] = false; //중복체크는 다시 되돌려주기
            }
        }
    }
}