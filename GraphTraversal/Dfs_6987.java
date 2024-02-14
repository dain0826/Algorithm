package GraphTraversal;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dfs_6987{
    static int[] team1 = {0,0,0,0,0,1,1,1,1,2,2,2,3,3,4}; //경기 진행 순서
    static int[] team2 = {1,2,3,4,5,2,3,4,5,3,4,5,4,5,5};
    static int[][] result = new int[6][3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t=0; t<4; t++) {
            int sum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<6; i++) {
                for(int j=0; j<3; j++) {
                    result[i][j] = Integer.parseInt(st.nextToken());
                    sum += result[i][j];
                }
            }
            if(sum>30) { //6팀*5경기 -> 결과값을 다 합치면 30이므로
                System.out.print(0 + " ");
                continue;
            }
            if(play(0)) System.out.print(1 + " ");
            else System.out.print(0 + " ");
        }
    }

    public static boolean play(int cnt) {
        if(cnt == 15) { //진행 가능한 경기 수는 총 15, cnt가 15가 됐다면 경기가 끝까지 진행된 것이므로
            return true;
        }
        //가능한 case는 승-패/패-승/무-무
        if(result[team1[cnt]][0] > 0 && result[team2[cnt]][2] > 0) { //team1이 승, team2가 패
            result[team1[cnt]][0]--; //결과값 하나씩 줄여주고
            result[team2[cnt]][2]--;
            if(play(cnt+1)) //다음경기를 진행
                return true;
            result[team1[cnt]][0]++; //원상복구
            result[team2[cnt]][2]++;
        }
        if(result[team1[cnt]][2] > 0 && result[team2[cnt]][0] > 0) { //team1이 패, team2가 승
            result[team1[cnt]][2]--;
            result[team2[cnt]][0]--;
            if(play(cnt+1))
                return true;
            result[team1[cnt]][2]++;
            result[team2[cnt]][0]++;
        }
        if(result[team1[cnt]][1] > 0 && result[team2[cnt]][1] > 0) { //team1과 team2 무승부
            result[team1[cnt]][1]--;
            result[team2[cnt]][1]--;
            if(play(cnt+1))
                return true;
            result[team1[cnt]][1]++;
            result[team2[cnt]][1]++;
        }
        return false;
    }
}