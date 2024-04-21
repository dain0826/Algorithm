package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dfs_16987 {
    static int N, answer;
    static int[][] egg;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        egg = new int[N][2];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            egg[i][0] = Integer.parseInt(st.nextToken()); //[i][0] 는 계란의 내구도
            egg[i][1] = Integer.parseInt(st.nextToken()); //[i][1] 는 계란의 무게
        }
        dfs(0,0);
        System.out.println(answer);
    }
    public static void dfs(int idx, int cnt) {
        if(idx==N || cnt == N-1) {
            answer = Math.max(answer, cnt);
            return;
        }
        if(egg[idx][0] <= 0) { //손에 든 계란이 깨진 계란이라면
            dfs(idx+1, cnt); //넘어간다
            return;
        }
        for(int i=0; i<N; i++) {
            if(idx == i || egg[i][0]<= 0) continue; //본인이거나 이미 깨진 계란이라면
            egg[i][0] -= egg[idx][1];
            egg[idx][0] -= egg[i][1];
            if(egg[i][0]<=0 && egg[idx][0]<=0) dfs(idx+1, cnt+2);
            else if(egg[i][0]<=0 || egg[idx][0]<=0) dfs(idx+1, cnt+1);
            else dfs(idx+1,cnt);
            egg[i][0] += egg[idx][1];
            egg[idx][0] += egg[i][1];
        }
    }


}
