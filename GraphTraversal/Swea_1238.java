package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea_1238 {
    static int N;
    static int start;
    static int[] person;
    static boolean[] visited;
    static ArrayList<Integer>[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int tc = 1; tc<= 10; tc++) {
            person = new int[101];
            arr = new ArrayList[101];
            visited = new boolean[101];
            for(int i=1; i<=100; i++) {
                arr[i] = new ArrayList<Integer>();
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N/2; i++) {
                arr[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
            }
            contact();
            int maxIdx = start;
            for(int i=1; i<= 100; i++) {
                if(person[maxIdx] <= person[i]) {
                    maxIdx = i;
                }
            }
            System.out.println("#" + tc + " " + maxIdx);
        }
    }

    public static void contact() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while(!queue.isEmpty()) {
            int now = queue.poll();
            for(int i=0; i<arr[now].size(); i++) {
                int next = arr[now].get(i);
                if(!visited[next]) {
                    visited[next] = true;
                    person[next] = person[now]+1;
                    queue.offer(next);
                }
            }
        }
    }
}
