package GraphTraversal;

import java.util.*;

class Solution {
    int[] dx = {0,0,-1,1};
    int[] dy = {-1,1,0,0};

    public int solution(int[][] maps) {
        int answer = 0;
        int[][] visited = new int[maps.length][maps[0].length];
        bfs(maps, visited);
        answer = visited[maps.length-1][maps[0].length-1];
        if(answer == 0) {
            answer = -1;
        }
        return answer;
    }

    public void bfs(int[][] maps, int[][] visited) {
        int x = 0;
        int y = 0;
        visited[x][y] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x,y});
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            for(int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx >= 0 && ny >= 0 && nx < maps.length && ny < maps[0].length) {
                    if(visited[nx][ny] == 0 && maps[nx][ny] == 1) {
                        visited[nx][ny] = visited[now[0]][now[1]] + 1;
                        queue.add(new int[] {nx,ny});
                    }
                }
            }
        }

    }
}