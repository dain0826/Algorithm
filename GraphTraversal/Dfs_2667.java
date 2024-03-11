package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Dfs_2667 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Integer> nums;
    static int cnt, temp;
    static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new ArrayList<>();
        map = new int[N][N];
        visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j] && map[i][j] ==1){
                    temp = 1;
                    cnt++;
                    dfs(i,j);
                    nums.add(temp);
                }
            }
        }
        Collections.sort(nums);
        System.out.println(cnt);
        for(int i=0; i<nums.size(); i++){
            System.out.println(nums.get(i));
        }

    }
    public static void dfs(int x, int y){
        visited[x][y] = true;
        for(int i=0; i<4; i++){
            int nx = x + delta[i][0];
            int ny = y + delta[i][1];
            if(nx>=0 && ny>=0 && nx<N && ny<N && !visited[nx][ny] && map[nx][ny] == 1){
                temp++;
                dfs(nx,ny);
            }
        }
    }
}
