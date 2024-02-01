package GraphTraversal;
import java.util.Scanner;

public class Dfs_15650 {
    static int N,M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        arr = new int[M];
        dfs(0, 0);
        System.out.println(sb);


    }


    public static void dfs(int depth, int save) { // depth만큼 출력하고 save부터 실행한다.
        if(depth == M) { //M만큼 채웠다면
            for(int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=save; i<N; i++) { //오름차순이기 때문에 이전에 어디서 시작했는지 받아온 save 값을 통해서 save 부터 dfs 실행
            arr[depth] = i+1;
            dfs(depth+1, i+1);
        }

    }

}
