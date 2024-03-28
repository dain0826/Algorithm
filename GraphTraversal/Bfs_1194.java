package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bfs_1194 {
    static int N, M, answer;
    static char[][] miro;
    static int mx, my; //민식이 위치 좌표
    static boolean[][][] visited;
    static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};

    static class Point{
        int x,y,cnt,key;
        public Point(int x, int y, int cnt, int key) {
            super();
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.key = key;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        miro = new char[N][M];
        visited = new boolean[64][N][M]; //열쇠 000000 ~ 111111 가능한 경우의 수 64가지
        answer = Integer.MAX_VALUE;
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                miro[i][j] = s.charAt(j);
                if(miro[i][j]=='0') { //민식이 위치 구하기
                    mx = i;
                    my = j;
                    miro[i][j]='.';
                }
            }
        }
        System.out.println(bfs());

    }
    public static int bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(mx, my, 0, 0));
        visited[0][mx][my] = true;

        while(!queue.isEmpty()) {
            Point now = queue.poll();
            int x = now.x;
            int y = now.y;
            int cnt = now.cnt;
            int key = now.key;

            if(miro[x][y] =='1') return cnt;
            for(int i=0; i<4; i++) {
                int nx = x + delta[i][0];
                int ny = y + delta[i][1];
                if(nx>=0 && ny>=0 && nx<N && ny<M && miro[nx][ny]!='#' && !visited[key][nx][ny]) { //범위내에 있고, 이동할 수 있고, 방문하지 않았다면
                    if(miro[nx][ny] =='.' || miro[nx][ny] == '1') {
                        visited[key][nx][ny] = true;
                        queue.offer(new Point(nx, ny, cnt+1, key));
                    }
                    else if(miro[nx][ny]>='a' && miro[nx][ny]<='z') { //열쇠를 만난다면
                        int newKey = 1 <<(miro[nx][ny]-'a');
                        newKey = newKey | key;
                        if(!visited[newKey][nx][ny]) {
                            visited[key][nx][ny] = true;
                            visited[newKey][nx][ny] = true;
                            queue.offer(new Point(nx, ny, cnt+1, newKey));
                        }
                    }
                    else if(miro[nx][ny]>='A' && miro[nx][ny]<='Z') { //문을 만난다면
                        int door = 1<<miro[nx][ny]-'A';
                        if((key & door) > 0) {
                            visited[key][nx][ny] = true;
                            queue.offer(new Point(nx, ny, cnt+1, key));
                        }

                    }
                }
            }
        }
        return -1;
    }
}
