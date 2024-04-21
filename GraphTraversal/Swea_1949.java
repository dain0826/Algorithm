package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Swea_1949{
    static int N,K; //N*N 크기의 맵, K만큼 봉우리 높이를 깎을 수 있다.
    static int[][] map, copy;
    static boolean[][] visited;
    static int high,answer; //가장 높은 봉우리의 높이, 가장 긴 등산로의 길이
    static ArrayList<int[]> peaks; //가장 높은 봉우리 list
    static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}}; //상하좌우로만 이동할 수 있다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            high = 0;
            answer = 0;
            map = new int[N][N];
            visited = new boolean[N][N];
            peaks = new ArrayList<>();
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(high<=map[i][j]){
                        if(high<map[i][j]){
                            peaks.clear();
                            peaks.add(new int[] {i,j});
                            high = map[i][j];
                        }
                        else {
                            peaks.add(new int[] {i,j});
                        }
                    }
                }
            }

            for(int i=0; i<peaks.size(); i++){
                visited[peaks.get(i)[0]][peaks.get(i)[1]] = true;
                dfs(peaks.get(i)[0], peaks.get(i)[1], high, 1,0);
                visited[peaks.get(i)[0]][peaks.get(i)[1]] = false;
            }
            System.out.println("#" + t + " " + answer);
        }
    }


    public static void dfs(int x, int y, int height, int move, int minus){
        answer = Math.max(answer, move);
        for(int i=0; i<4; i++) {
            int nx = x + delta[i][0];
            int ny = y + delta[i][1];
            if(nx<0 || ny<0 || nx>=N || ny>= N) continue;
            if(visited[nx][ny]) continue;
            if(height>map[nx][ny]){
                visited[nx][ny] = true;
                dfs(nx, ny, map[nx][ny], move+1, minus);
                visited[nx][ny] = false;
            }
            else if(minus==0){
                if(height > map[nx][ny] - K){
                    visited[nx][ny] = true;
                    dfs(nx,ny,height-1, move+1, minus+1);
                    visited[nx][ny] = false;
                }
            }
        }
    }
}
