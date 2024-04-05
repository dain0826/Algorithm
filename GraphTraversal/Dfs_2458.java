package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Dfs_2458{
    static int N, M;
    static ArrayList<Integer>[] small;
    static ArrayList<Integer>[] tall;
    static Student[] students;
    static boolean[] visited;
    static int answer;
    static int cnt;

    static class Student{
        int prev = 0;
        int next = 0;

        public Student(int prev, int next) {
            this.prev = prev;
            this.next = next;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        students = new Student[N+1];
        small = new ArrayList[N+1];
        tall = new ArrayList[N+1];
        visited = new boolean[N+1];
        answer = 0;
        for(int i=1; i<=N; i++) {
            students[i] = new Student(0,0);
            small[i] = new ArrayList<>();
            tall[i] = new ArrayList<>();
        }
        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            small[a].add(b);
            tall[b].add(a);
        }
        for(int i=1;i<=N; i++) {
            cnt = 0;
            visited = new boolean[N+1];
            visited[i] = true;
            dfs1(i);
            students[i].prev = cnt;
            cnt = 0;
            visited = new boolean[N+1];
            visited[i] = true;
            dfs2(i);
            students[i].next = cnt;
            if(students[i].prev + students[i].next == N-1) answer++;
        }
        System.out.println(answer);


    }
    public static void dfs1(int start) {
        for(int j : small[start]) {
            if(!visited[j]) {
                visited[j] = true;
                cnt++;
                dfs1(j);
            }
        }
    }
    public static void dfs2(int start) {
        for(int j : tall[start]) {
            if(!visited[j]) {
                visited[j] = true;
                cnt++;
                dfs2(j);
            }
        }
    }

}
