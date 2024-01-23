package GraphTraversal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bfs_1697 {
    static int N, K;
    static int[] visited = new int[100001];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        K = scan.nextInt();
        int result = BFS(N);
        System.out.println(result);
    }
    public static int BFS(int start) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        while(!queue.isEmpty()) {
            int idx = queue.poll();
            if(idx == K) {
                return visited[idx];
            }
            if((idx-1) >=0 && visited[idx-1]==0) {
                visited[idx-1] = visited[idx] + 1;
                queue.add(idx-1);
            }
            if((idx+1) <= 100000 && visited[idx+1] ==0){
                visited[idx+1] = visited[idx] + 1;
                queue.add(idx+1);
            }
            if(2*idx <= 100000 && visited[2*idx] ==0) {
                visited[2*idx] = visited[idx] + 1;
                queue.add(2*idx);
            }
        }
        return -1;
    }
}
