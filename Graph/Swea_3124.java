package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea_3124 {
    static class Edge implements Comparable<Edge>{
        int from, to, weight;

        Edge(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
    static int V, E;
    static Edge[] edgeList;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            edgeList = new Edge[E];
            parents = new int[V+1];
            for(int i=0; i<E; i++) {
                st = new StringTokenizer(br.readLine());
                edgeList[i] = new Edge(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            }
            Arrays.sort(edgeList);
            make();
            long weight = 0;
            int cnt = 0;
            for(int i=0; i<E; i++) {
                if(!union(edgeList[i].from, edgeList[i].to)) continue;
                weight += edgeList[i].weight;
                if(++cnt == V-1) break;
            }
            System.out.println("#" + tc + " " + weight);
        }
    }

    static void make() {
        for(int i=1; i<=V; i++) {
            parents[i] = i;
        }
    }
    static int find(int num) {
        if(parents[num] == num) {
            return num;
        }
        return parents[num] = find(parents[num]);
    }
    static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot) return false;
        parents[Math.max(aRoot, bRoot)] = Math.min(aRoot, bRoot);
        return true;
    }

}
