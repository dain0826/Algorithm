package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bfs_4485 {

    static class Point implements Comparable<Point>{
        int start, end, cost;
        public Point(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
        @Override
        public int compareTo(Point o) { //cost 오름차순 정렬
            return this.cost - o.cost;
        }
    }
    static int N;
    static int[][] map, lost; //map : 도둑루피의 크기를 담을 배열, lost: 지금까지 잃은 루피를 담을 배열
    static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=0;
        while(true) {
            N = Integer.parseInt(br.readLine());
            if(N==0) { //0이 입력으로 들어오면
                break;
            }
            t++;
            map = new int[N][N];
            visited = new boolean[N][N];
            lost = new int[N][N];
            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                Arrays.fill(lost[i], Integer.MAX_VALUE);
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println("Problem " + t + ": " + zelda());
        }



    }
    public static int zelda() {
        Queue<Point> queue = new PriorityQueue<>(); //우선순위 큐
        lost[0][0] = map[0][0];
        queue.offer(new Point(0, 0, lost[0][0])); //링크는 (0,0) 에서 출발
        visited[0][0] = true;
        while(!queue.isEmpty()) {
            Point now = queue.poll();
            for(int i=0; i<4; i++) {
                int nx = now.start + delta[i][0];
                int ny = now.end + delta[i][1];
                if(nx>=0 && ny>=0 && nx<N && ny <N && !visited[nx][ny]) { //범위 내에 있고 방문하지 않았다면
                    if(lost[nx][ny] > now.cost + map[nx][ny]){
                        lost[nx][ny] = now.cost + map[nx][ny]; //잃은 루피 수 업데이트 = 현재까지 잃은 루피 + 다음 위치의 도둑루피 크기
                        queue.offer(new Point(nx,ny, lost[nx][ny]));
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        return lost[N-1][N-1]; //동굴 건너편까지 이동했을 때 잃은 루피
    }

}
