package GraphTraversal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bfs_13549 {
    static int N, K;
    static boolean[] visited = new boolean[100001];
    static int min = Integer.MAX_VALUE;
    static class Point{
        int x;
        int time;

        public Point(int x, int time){
            this.x = x;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        System.out.println(bfs(N,K));
    }

    public static int bfs(int start, int finish) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(start,0));
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            visited[now.x] = true;
            if(now.x == finish) min = Math.min(min, now.time);
            if (2 * now.x <= 100000 && !visited[now.x*2]) {
                queue.offer(new Point(now.x*2, now.time));
            }
            if(now.x + 1 <= 100000 && !visited[now.x+1]){
                queue.offer(new Point(now.x+1, now.time+1));
            }
            if(now.x -1 >=0 && !visited[now.x-1]){
                queue.offer(new Point(now.x-1, now.time+1));
            }
        }
        return min;
    }

}
