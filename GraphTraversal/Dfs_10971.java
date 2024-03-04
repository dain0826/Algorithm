package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dfs_10971{
    static int N;
    static int answer = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<N; i++) { //출발 도시
            visited = new boolean[N]; //방문 배열 초기화
            visited[i] = true; //출발 도시 방문 체크
            travel(i,i,0,0);
        }
        System.out.println(answer);

    }
    public static void travel(int start, int cur, int cnt, int cost) {
        if(cnt == N-1) { //다 돌았다면
            if(map[cur][start] != 0) { //출발지로 돌아오는 경로가 있다면
                cost += map[cur][start];
                answer = Math.min(answer, cost); //비용 최솟값 업데이트
                return;
            }
        }
        else {
            for(int i=0; i<N; i++) {
                if(!visited[i] && map[cur][i]!=0) { //방문하지 않은 도시고 경로가 존재한다면
                    visited[i] = true;
                    travel(start, i, cnt+1, cost+map[cur][i]); //다음 도시 방문
                    visited[i] = false; //되돌리기
                }
            }
        }
    }
}
