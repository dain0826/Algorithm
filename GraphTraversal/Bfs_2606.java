package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bfs_2606 {
    static int N, M, cnt;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i=1; i<=N; i++) {
            arr[i] = new ArrayList<Integer>();
        }
        M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }
        rumor(1);
        System.out.println(cnt);
    }
    public static void rumor(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()) {
            int now = queue.poll();
            for(int i=0; i<arr[now].size(); i++) {
                int next = arr[now].get(i);
                if(!visited[next]) {
                    visited[next] = true;
                    cnt++;
                    queue.add(next);
                }
            }
        }
    }

}
