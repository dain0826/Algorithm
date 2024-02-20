package BruteForce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bf_15686 {
    static int N, M, ans = Integer.MAX_VALUE;
    static boolean[] checked;
    static List<int[]> home, chicken;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        home = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                switch (sc.nextInt()) {
                    case 1:
                        home.add(new int[]{i, j});
                        break;
                    case 2:
                        chicken.add(new int[]{i, j});
                        break;
                }
        }
        checked = new boolean[chicken.size()];
        perm(0, 0);

        System.out.println(ans);
    }

    static void perm(int idx, int cnt) {
        if (cnt == M) {//체크된 치킨집이 M개가 됐다면
            int dist = 0;

            for (int[] h : home) { //각 집마다
                int tmp = Integer.MAX_VALUE;
                for (int i = 0; i < checked.length; i++) {//체크된 치킨집까지의
                    if (checked[i])
                        tmp = Math.min(tmp, Math.abs(h[0] - chicken.get(i)[0]) + Math.abs(h[1] - chicken.get(i)[1])); //거리를 구한다.
                }
                dist += tmp;
            }
            ans = Math.min(ans, dist); //체크된 치킨집들의 조합에서 구한 dist값이 더 적다면 answer 업데이트
            return;
        }

        for (int i = idx; i < checked.length; i++) {
            checked[i] = true;
            perm(i+1, cnt + 1);
            checked[i] = false;
        }
    }
}