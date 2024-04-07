package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Si_17144{
    static int R,C,T;
    static int ac, answer;
    static int[][] dust, copy;
    static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T  = Integer.parseInt(st.nextToken());
        dust = new int[R][C];
        for(int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++) {
                dust[i][j] = Integer.parseInt(st.nextToken());
                if(dust[i][j] == -1) {
                    ac = i; //공기청정기 아래칸 row번호 저장
                }
            }
        }
        for(int i=0; i<T; i++){
            dust = spread();
            clean();
        }
        restDust();
        System.out.println(answer);


    }
    public static int[][] spread() {
        copy = new int[R][C];
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(dust[i][j] ==0) continue;
                if(dust[i][j] == -1){
                    copy[i][j] = -1;
                    continue;
                }
                copy[i][j] += dust[i][j];
                int amount = dust[i][j]/5;
                for(int d=0; d<4; d++){
                    int nx = i + delta[d][0];
                    int ny = j + delta[d][1];
                    if(nx<0||ny<0||nx>=R||ny>=C) continue;
                    if(dust[nx][ny]==-1) continue;
                    copy[nx][ny] += amount;
                    copy[i][j] -= amount;
                }
            }
        }
        return copy;
    }
    public static void clean() {
        //윗칸
        for(int i = ac-2; i>0; i--){
           dust[i][0] = dust[i-1][0];
        }
        for(int i=0; i<C-1; i++){
            dust[0][i] = dust[0][i+1];
        }
        for(int i=0; i<ac-1; i++){
            dust[i][C-1] = dust[i+1][C-1];
        }
        for(int i=C-1; i>1; i--){
            dust[ac-1][i] = dust[ac-1][i-1];
        }
        dust[ac-1][1] = 0;
        //아랫칸

        for(int i= ac+1; i<R-1; i++){
            dust[i][0] = dust[i+1][0];
        }
        for(int i=0; i<C-1; i++){
            dust[R-1][i] = dust[R-1][i+1];
        }
        for(int i=R-1; i>ac; i--){
            dust[i][C-1] = dust[i-1][C-1];
        }
        for(int i=C-1; i>1; i--){
            dust[ac][i] = dust[ac][i-1];
        }
        dust[ac][1] = 0;
    }

    public static void restDust(){
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(dust[i][j] !=0 && dust[i][j]!= -1) {
                    answer += dust[i][j];
                }
            }
        }
    }
}
