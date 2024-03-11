package GraphTraversal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bfs_5014 {
    static int F,S,G,U,D;
    static int[] elev;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        F = scan.nextInt();
        S = scan.nextInt();
        G = scan.nextInt();
        U = scan.nextInt();
        D = scan.nextInt();
        elev = new int[F+1];
        visited = new boolean[F+1];
        if(S==G) {
            System.out.println(0);
            return;
        }
        bfs();
        System.out.println(elev[G] == 0 ? "use the stairs" : elev[G]);
    }
    public static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(S);
        visited[S] = true;
        while(!queue.isEmpty()){
            int now = queue.poll();
            if(now+U <= F && !visited[now+U]){
                queue.add(now+U);
                visited[now+U] = true;
                elev[now+U] = elev[now] + 1;
            }
            if(now-D>0 && !visited[now-D]){
                queue.add(now-D);
                visited[now-D] = true;
                elev[now-D] = elev[now] + 1;
            }
        }
    }
}
