package GraphTraversal;

import java.util.Arrays;
import java.util.Scanner;
public class Swea_6808{
    static int[] ky, iy;
    static boolean[] checked= new boolean[19];
    static int[] card = new int[9]; //인영이가 카드를 내는 순서
    static int win; //규영이가 게임을 이기는 수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        boolean[] num = new boolean[19]; //18장의 카드, TRUE-> 규영, FALSE -> 인영
        ky = new int[9]; //규영이의 카드덱
        iy = new int[9]; //인영이의 카드덱
        for(int test_case = 1; test_case <= T; test_case++)
        {
            Arrays.fill(num, false);
            for(int i=0; i<9; i++) {
                ky[i] = sc.nextInt();
                num[ky[i]] = true; //TRUE면 규영이가 받는 카드
            }
            int idx = 0;
            for(int i=1; i<=18; i++) {
                if(!num[i]) { //FALSE면 인영이가 받는 카드
                    iy[idx++] = i;
                }
            }
            Arrays.fill(checked, false);
            Arrays.fill(card, 0);
            win = 0;
            perm(0);
            //9! = 362880
            System.out.println("#" + test_case  + " " +  win + " " + (362880-win));
        }
    }
    public static void perm(int cnt) { //인영이가 카드를 내는 방법 순열
        if(cnt == 9) {
            int kScore = 0;
            int iScore = 0;
            for(int i=0; i<9; i++) {
                if(ky[i] > card[i]) { //규영이의 카드가 더 높은 수라면
                    kScore += ky[i] + card[i]; //규영이 점수를 올려주고
                }
                else if(ky[i]<card[i]) { //인영이 카드가 더 높은 수라면
                    iScore += ky[i] + card[i]; //인영이 점수를 올려준다
                }
            }
            if(kScore > iScore) { //규영이의 점수가 더 높다면
                win++;
            }
            return;
        }

        for(int i=0; i<9; i++) {
            if(checked[i]) {
                continue;
            }
            card[cnt] = iy[i];
            checked[i] = true;
            perm(cnt + 1);
            checked[i] = false;
        }
    }
}
