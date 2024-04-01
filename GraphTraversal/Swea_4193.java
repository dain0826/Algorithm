package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea_4193 {
    static int N;
    static int sx, sy, dx, dy; //출발지점 , 도착지점
    static int[][] map;
    static boolean[][] visited;
    static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
    static int answer;

    static class Location{
        int x, y, time;

        public Location(int x, int y, int time) {
            super();
            this.x = x;
            this.y = y;
            this.time = time;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visited = new boolean[N][N];
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            st = new StringTokenizer(br.readLine());
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            dx = Integer.parseInt(st.nextToken());
            dy = Integer.parseInt(st.nextToken());

            System.out.println("#" + t + " " + (swim() ? answer:-1));
        }

    }
    public static boolean swim() {
        Queue<Location> queue = new LinkedList<>();
        queue.offer(new Location(sx, sy, 0)); //출발지점 넣기
        visited[sx][sy] = true;
        while(!queue.isEmpty()) {
            Location now = queue.poll();
            if(now.x==dx && now.y==dy) { //목적지에 도착했다면
                answer = now.time; //answer없데이트
                return true;
            }
            for(int i=0; i<4; i++) {
                int nx = now.x+delta[i][0];
                int ny = now.y+delta[i][1];
                if(nx<0 || ny<0 || nx>=N || ny>=N) continue; //범위내에있지않다면
                if(map[nx][ny] == 1 ||visited[nx][ny]) continue; //장애물이거나 이전에 방문했다면
                if(map[nx][ny] == 2) {
                    if((now.time+1)%3==0) { //소용돌이가 없다면
                        visited[nx][ny] = true;
                        queue.add(new Location(nx,ny,now.time+1));
                    }
                    else { //소용돌이가 아직 있다면
                        queue.add(new Location(now.x, now.y, now.time+1));
                    }
                }
                else {
                    visited[nx][ny] = true;
                    queue.add(new Location(nx,ny,now.time+1));
                }
            }
        }
        return false;
    }

}
