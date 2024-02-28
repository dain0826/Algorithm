package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Graph_1753 {
    static class Node implements Comparable<Node>{
        int index, cost;

        public Node(int index, int cost){
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    static ArrayList<Node>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        boolean[] check = new boolean[V+1];
        graph = new ArrayList[V+1];
        for(int i=1; i<=V; i++) {
            graph[i] = new ArrayList<Node>();
        }
        int[] dist = new int[V+1];
        final int INF = Integer.MAX_VALUE;
        Arrays.fill(dist, INF);
        int start = Integer.parseInt(br.readLine());
        dist[start] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start,0));
        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[from].add(new Node(to, weight));
        }
        while(!queue.isEmpty()) {
            int now = queue.poll().index;
            if(!check[now]) {
                check[now] = true;
                for(Node next : graph[now]) {
                    if(dist[next.index] > dist[now] + next.cost) {
                        dist[next.index] = dist[now] + next.cost;
                        queue.offer(new Node(next.index, dist[next.index]));
                    }
                }
            }
        }
        for(int i=1; i<=V; i++) {
            System.out.println(dist[i]==INF ? "INF" : dist[i]);
        }

    }

}
