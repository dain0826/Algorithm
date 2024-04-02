package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Dfs_2112{
    static int D,W,K; //두께, 가로 크기, 합격 기준
    static int[][] cell, copy; //원본, 복사본
    static boolean[] medi; //약품을 쓰는 막 결정 배열
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            cell = new int[D][W];
            medi = new boolean[D];
            answer = Integer.MAX_VALUE;
            for(int i=0; i<D; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<W; j++) {
                    cell[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            copyCell();
            if(test() || K==1) {
                answer = 0;
            }
            else {
                choose(0);
            }
            System.out.println("#" + t + " " + answer);
        }
    }
    public static void choose(int cnt) { //약품 투입할 막 선택
        if(cnt==D) {
            copyCell();
            ABnot(0,0);
            return;
        }
        medi[cnt] = true;
        choose(cnt+1);
        medi[cnt] = false;
        choose(cnt+1);
    }
    public static void ABnot(int cnt, int now) { //약품변경횟수, 현재 막 인덱스
        if(cnt>=answer) { //기존 answer보다 초과하면
            return;
        }
        if(now==D) { //모든 막까지 다 돌았다면
            if(test()) {
                answer = Math.min(answer, cnt);
            }
            return;
        }
        if(medi[now]) { //now번째 막에 약품을 쓸지 여부를 체크
            Arrays.fill(copy[now], 0); //A약품
            ABnot(cnt+1, now+1);
            Arrays.fill(copy[now], 1); //B약품
            ABnot(cnt+1, now+1);
        }
        else {
            ABnot(cnt, now+1); //약품을 쓰지 않았으므로 cnt그대로, 다음 막 진행
        }

    }

    public static void copyCell(){
        copy = new int[D][W];
        for(int i=0; i<D; i++) {
            for(int j=0; j<W; j++) {
                copy[i][j] = cell[i][j];
            }
        }
    }

    public static boolean test() { //성능검사 통과 여부를 확인하는 메서드
        for(int i=0; i<W; i++) {
            boolean flag = false;
            int cnt = 1;
            int start = copy[0][i];
            for(int j=1; j<D; j++) {
                if(start != copy[j][i]) {
                    start = copy[j][i];
                    cnt = 1;
                    continue;
                }
                else {
                    cnt++;
                }
                if(cnt==K) { //동일한 특성을 지닌 셀이 k개 연속적으로 있다면
                    flag = true;
                    break;
                }
            }
            if(flag == false) return false;
        }
        return true;
    }
}
