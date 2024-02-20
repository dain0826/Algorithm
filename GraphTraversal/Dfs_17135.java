package GraphTraversal;

import java.io.*;
import java.util.*;

public class Dfs_17135 {
    static class Enemy implements Comparable<Enemy> {
        int x, y, d;

        public Enemy(int x, int y, int d) { //적
            this.x = x;
            this.y = y;
            this.d = d;
        }

        @Override
        public int compareTo(Enemy o) {
            if (this.d == o.d) { // 궁사로부터 거리가 같다면
                return this.y - o.y; // 왼쪽에 있는 적이 더 높은 우선순위
            } else
                return this.d - o.d;
        }
    }

    static int N, M, D;
    static int map[][];
    static List<int[]> list;
    static int archer[];
    static int answer; // 공격할 수 있는 최대 적 수(정답)

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        archer = new int[3]; // 궁수 3명
        list = new ArrayList<>(); // 적 (x,y) 좌표를 담을 리스트

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) // 적이면
                    list.add(new int[] {i, j}); //좌표 저장
            }
        }

        perm(0, 0); // 궁수 3명 배치(조합)
        System.out.println(answer);
    }

    private static void perm(int idx, int start) {
        if (idx == 3) { // 3명의 자리가 정해졌으면
            List<int[]> data = copy(list);
            attack(data); // 공격
            return;
        }
        for (int i = start; i < M; i++) { //3명의 자리가 다 정해지지 않았다면
            archer[idx] = i;
            perm(idx + 1, i + 1);
        }
    }

    private static List<int[]> copy(List<int[]> list) { // 적 좌표 복사
        List<int[]> tmp = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int[] cur = list.get(i);
            tmp.add(new int[] { cur[0], cur[1] });
        }
        return tmp;
    }

    private static void attack(List<int[]> list) {
        int count = 0; // 공격한 몬스터 수

        while (!list.isEmpty()) {
            List<int[]> targets = new ArrayList<>(); // 궁수 3명이 노리는 적 좌표
            for (int k = 0; k < 3; k++) {
                PriorityQueue<Enemy> pq = new PriorityQueue<>();
                for (int i = 0; i < list.size(); i++) { // 현재 남아있는 몬스터들
                    int[] cur = list.get(i);
                    int dis = Math.abs(cur[0] - N) + Math.abs(cur[1] - archer[k]);
                    if (dis <= D) // 사정거리 안이면
                        pq.add(new Enemy(cur[0], cur[1], dis)); //화살 쏠 적 후보에 올림
                }
                if (!pq.isEmpty()) {
                    Enemy target = pq.poll(); //우선순위에 따라 제일 왼쪽&&가까이 있는 적
                    boolean flag = false; // 두 명 이상의 궁수가 노리는지 확인
                    for (int i = 0; i < targets.size(); i++) {
                        int[] temp = targets.get(i);
                        if (target.x == temp[0] && target.y == temp[1]) // 다른 궁수도 노리고 있음
                            flag = true;
                    }
                    if (!flag) { //다른 궁수들이 노리고 있지 않다면
                        targets.add(new int[] {target.x, target.y}); //타겟에 추가
                    }
                }
            }
            for (int i = 0; i < targets.size(); i++) {
                for (int j = list.size() - 1; j >= 0; j--) {
                    if (targets.get(i)[0] == list.get(j)[0] && targets.get(i)[1] == list.get(j)[1]) {
                        list.remove(j);
                        count++;
                        break;
                    }
                }
            }
            // 한칸씩 이동
            for (int i = list.size() - 1; i >= 0; i--) {
                list.get(i)[0] += 1;
                if (list.get(i)[0] == N) //성에 도착하면
                    list.remove(i); //적 소멸
            }
        }
        answer = Math.max(answer, count); //answer 업데이트
    }
}