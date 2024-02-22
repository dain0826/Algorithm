package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bfs_17471{

    static int N;
    static int answer = Integer.MAX_VALUE;
    static int[] area; //index : 구역 번호, 값 : 인구 수
    static boolean[] checked; //true면 A구역, false면 B구역에 속함
    static ArrayList<Integer>[] nearBy; //서로 인접한 area

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        area = new int[N+1];
        checked = new boolean[N+1];
        nearBy = new ArrayList[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            area[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; i++) { //인접한 구역의 정보 담기
            nearBy[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for(int j = 0; j<cnt; j++) {
                nearBy[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        AB(1);
        if(answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);
    }
    public static int calc(ArrayList<Integer> a, ArrayList<Integer> b) { //선거구에 포함된 인구 수 차이 계산
        int sumA = 0;
        int sumB = 0;
        for(int i=0; i<a.size(); i++) {
            sumA += area[a.get(i)];
        }
        for(int i=0; i<b.size(); i++) {
            sumB += area[b.get(i)];
        }
        return Math.abs(sumA-sumB);
    }

    public static boolean condi(ArrayList<Integer> list) {
        if(list.size()<1) {
            return false;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[N+1];
        queue.offer(list.get(0));
        visited[list.get(0)] = true;
        int cnt = 1;
        while(!queue.isEmpty()) {
            int now = queue.poll();
            for(int i=0; i<nearBy[now].size(); i++) {
                int next = nearBy[now].get(i);
                if(list.contains(next) && !visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    cnt++;
                }
            }
        }
        if(cnt != list.size()) return false;

        return true;
    }
    public static void AB(int cnt) { //A선거구, B선거구에 들어갈 구역 정하기
        if(cnt == N+1) { //구역이 다정해졌다면 조건 체크
            ArrayList<Integer> areaA = new ArrayList<>();
            ArrayList<Integer> areaB = new ArrayList<>();

            for(int i=1; i<=N; i++) {
                if(checked[i]) {
                    areaA.add(i);
                }
                else {
                    areaB.add(i);
                }
            }
            if(condi(areaA) && condi(areaB)) { //각 선거구 조건(1구역 이상, 연결) 체크
                answer = Math.min(answer, calc(areaA, areaB)); //선거구간 인구 차 최솟값 업데이트
            }
            return;
        }
        checked[cnt] = true;
        AB(cnt+1);
        checked[cnt] = false;
        AB(cnt+1);
    }
}
