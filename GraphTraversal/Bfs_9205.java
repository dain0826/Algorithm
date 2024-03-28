package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bfs_9205 {
    static int N;
    static Point[] market;
    static Point festival;
    static boolean[] visited;
    static Queue<Point> queue;
    static boolean success;

    static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            market = new Point[N];
            visited = new boolean[N];
            queue = new LinkedList<>();
            success = false;
            queue.offer(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                market[i] = new Point(x,y);
            }
            st = new StringTokenizer(br.readLine());
            festival = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            while(!queue.isEmpty()) {
                Point now = queue.poll();
                if(distance(now, festival)) {
                    success = true;
                    break;
                }
                for(int i=0; i<N; i++) {
                    Point store = market[i];
                    if(distance(now, store) && !visited[i]) {
                        queue.offer(store);
                        visited[i] = true;
                    }
                }
            }
            System.out.println(success ? "happy" : "sad");
        }

    }

    public static boolean distance(Point p1, Point p2) {
        return (Math.abs(p1.x-p2.x) + Math.abs(p1.y-p2.y)<= 1000);
    }

}
