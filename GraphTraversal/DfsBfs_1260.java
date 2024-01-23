package GraphTraversal;

import java.util.*;

public class DfsBfs_1260 {
    static boolean visited[];
    static ArrayList<Integer>[] A;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(); //노드개수
        int M= scan.nextInt(); //에지개수
        int Start = scan.nextInt();; //시작점

        A = new ArrayList[N+1];
        for (int i=1; i<=N; i++) {
            A[i] = new ArrayList<Integer>();
        }
        for (int i=0; i<M; i++) {
            int S = scan.nextInt();
            int E = scan.nextInt();
            A[S].add(E);
            A[E].add(S);
        }
        for(int i = 1; i<= N;i++) {
            Collections.sort(A[i]);
        }
        visited = new boolean[N+1];
        DFS(Start);
        System.out.println();
        visited = new boolean[N+1];
        BFS(Start);


    }

    private static void DFS(int node) { //DFS 재귀로
        System.out.print(node + " ");
        visited[node] = true;
        for(int i : A[node]) {
            if(!visited[i]) {
                DFS(i);
            }
        }
    }

    public static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(node);
        visited[node] = true;

        while(!queue.isEmpty()) {
            int now_node = queue.poll();
            System.out.print(now_node + " ");
            for(int i : A[now_node]) {
                if(!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }

    }
}
