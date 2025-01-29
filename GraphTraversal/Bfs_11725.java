package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bfs_11725 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] arr = new ArrayList[N+1];
        boolean[] visited = new boolean[N+1];
        int[] parent = new int[N+1];
        for(int i=1; i<=N; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i=1; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        visited[1] = true;
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int i : arr[now]){
                if(!visited[i]){
                    visited[i] = true;
                    parent[i] = now;
                    queue.offer(i);
                }
            }
        }
        for(int i=2; i<=N; i++){
            System.out.println(parent[i]);
        }
    }

}
