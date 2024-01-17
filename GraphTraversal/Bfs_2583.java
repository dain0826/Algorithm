package GraphTraversal;

import java.util.*;

public class Bfs_2583 {
    static int M,N,K;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx ={0,1,0,-1};
    static int[] dy ={1,0,-1,0};
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        M = scan.nextInt();
        N = scan.nextInt();
        K = scan.nextInt();
        map = new int[N][M];
        visited = new boolean[N][M];
        ArrayList<Integer> spaces = new ArrayList<Integer>();
        int answer = 0;

        for(int i=0; i<K;i++) {
            int x1 = scan.nextInt();
            int y1 = scan.nextInt();
            int x2 = scan.nextInt();
            int y2 = scan.nextInt();
            for(int x=x1; x<x2; x++) {
                for(int y=y1; y<y2; y++){
                    map[x][y] = 1;
                }
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0; j<M;j++) {
                if(!visited[i][j] && map[i][j] == 0) {
                    answer++;
                    int space = BFS(i,j);
                    spaces.add(space);
                }
            }
        }
        System.out.println(answer);
        Collections.sort(spaces);
        for(int i : spaces) {
            System.out.print(i + " ");
        }




    }
    public static int BFS(int x, int y){
        int count = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x,y});
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            visited[x][y] = true;

            for(int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx >=0 && ny>=0 && nx<N && ny<M) {
                    if(!visited[nx][ny] && map[nx][ny] == 0) {
                        queue.add(new int[] {nx,ny});
                        visited[nx][ny] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
