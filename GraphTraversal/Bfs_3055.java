package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bfs_3055 {
    static int R,C;
    static char[][] map;
    static int[][] water; //물이 차는 시간을 담는 배열
    static int hx, hy; //고슴도치의 위치
    static int answer = -1;
    static Queue<Point> wq= new LinkedList<>();
    static boolean[][] visited;
    static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
    static class Point{
        int x,y;
        int time;
        public Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        water = new int[R][C];
        for(int i=0; i<R; i++) {
            String s = br.readLine();
            for(int j=0; j<C; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'S') { //고슴도치 위치 파악
                    hx = i;
                    hy = j;
                }
                water[i][j] = -1; //물 초기 값은 -1로 세팅
                if(map[i][j] == '*') { //물이면
                    wq.offer(new Point(i,j,0)); //water 큐에 담는다
                    water[i][j] = 0; //0분에 차있는 물
                }

            }
        }
        water(); //물 먼저 채우고
        escape();
        System.out.println((answer !=-1) ? answer : "KAKTUS");
    }
    public static void escape() {
        Queue<Point> hq = new LinkedList<>();
        hq.offer(new Point(hx, hy,0));
        visited[hx][hy] = true;
        while(!hq.isEmpty()) {
            Point now = hq.poll();
            if(map[now.x][now.y] == 'D') { //비버의 굴이라면
                answer = now.time; //answer 업데이트
                return;
            }
            for(int i=0; i<4; i++) {
                int nx = now.x + delta[i][0];
                int ny = now.y + delta[i][1];
                if(nx<0 || ny<0 || nx>=R || ny>=C) continue; //범위 내에 있지 않다면
                if(map[nx][ny] == '*' || map[nx][ny] == 'X' || visited[nx][ny]) continue; //물이거나, 돌이거나, 이미 방문했다면
                if((water[nx][ny]!= -1) &&(water[nx][ny] <= now.time + 1)) continue; //물이 차는 시간이 더 빠르다면
                hq.offer(new Point(nx, ny, now.time+1));
                visited[nx][ny] = true;
            }

        }
    }
    public static void water() {
        while(!wq.isEmpty()) {
            Point now = wq.poll();
            for(int i=0; i<4; i++) {
                int nx = now.x + delta[i][0];
                int ny = now.y + delta[i][1];
                if(nx<0 || ny<0 || nx>=R || ny>=C) continue;
                if(map[nx][ny] == 'X' || map[nx][ny] == 'D') continue; //돌, 비버의 굴은 지나갈 수 없다
                if(water[nx][ny] != -1) continue; // 이미 물이 차있다면
                wq.offer(new Point(nx, ny, now.time+1));
                water[nx][ny] = now.time+1; //물이 차는 시간 업데이트
            }
        }

    }

}
