package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bfs_16236{
    static class Food implements Comparable<Food>{
        int x,y,len;
        public Food(int x, int y, int len) {
            this.x = x;
            this.y = y;
            this.len = len;
        }
        @Override
        public int compareTo(Food o) {
            if(this.len == o.len) {
                if(this.x == o.x) {
                    return Integer.compare(this.y, o.y);
                }
                else return Integer.compare(this.x, o.x);
            }
            else return Integer.compare(this.len, o.len);
        }

    }
    static int N, cnt, time;
    static int babyS = 2; //아기상어의 처음 크기는 2
    static int babyX, babyY;
    static int[][] map;
    static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}}; //상하좌우


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9) {
                    babyX = i;
                    babyY = j;
                    map[i][j] = 0;
                }
            }
        }

        while(true){
            Food food = bfs(); //제일 가까운 먹이 찾기
            if(food == null) { //없다면 break
                break;
            }
            map[food.x][food.y] = 0; //물고기 잡아먹음
            babyX = food.x; //아기상어 위치 갱신
            babyY = food.y;
            time += food.len; //물고기가 있던 위치까지 가는데 걸린 시간
            cnt++;
            if(cnt == babyS) { //자기 크기만큼 물고기 수를 잡아먹었다면
                babyS++; //크기 증가
                cnt = 0;
            }
        }
        System.out.println(time);
    }

    public static Food bfs(){
        PriorityQueue<Food> pq = new PriorityQueue<>(); //잡아먹을 수 있는 물고기 위치 (우선순위적용)
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> q = new LinkedList<>(); //아기상어 위치 담을 큐
        int time = 0;
        q.add(new int[] {babyX,babyY,time});
        visited[babyX][babyY] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i=0; i<4; i++){
                int nx = now[0] + delta[i][0];
                int ny = now[1] + delta[i][1];
                if(nx>=0 && ny>=0 && nx<N && ny<N && !visited[nx][ny] && map[nx][ny]<= babyS){
                    visited[nx][ny] = true;
                    q.add(new int[] {nx,ny,now[2]+1});
                    if(map[nx][ny] != 0 && map[nx][ny] < babyS){ //자신의 크기보다 작은 물고기가 있다면
                        pq.add(new Food(nx,ny,now[2]+1)); //우선순위큐에 추가
                    }
                }
            }
        }
        if(pq.isEmpty()) return null; //잡아먹을 수 있는 물고기가 없다면 null
        return pq.poll(); //우선순위 큐이므로 그냥 poll하면 됨
    }
}

