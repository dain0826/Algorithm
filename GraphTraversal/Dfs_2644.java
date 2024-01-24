package GraphTraversal;

import java.util.ArrayList;
import java.util.Scanner;

public class Dfs_2644 {

    static ArrayList<Integer>[] A;
    static boolean[] checked;
    static int answer;
    static int p2;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int p1 = scan.nextInt();
        p2 = scan.nextInt();
        int m = scan.nextInt();
        A = new ArrayList[N + 1];
        checked = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            A[a].add(b);
            A[b].add(a);
        }
        answer = -1;
        DFS(p1,1);
        System.out.println(answer);
    }
    public static void DFS(int p, int depth){
        if (checked[p])
            return;
        checked[p] = true;
        for (int j : A[p]) {
            if (j == p2) {
                answer = depth;
                return;
            }
            if (!checked[j])
                DFS(j, depth +1);
        }
    }
}