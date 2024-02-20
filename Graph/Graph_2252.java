package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Graph_2252{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] cnt = new int[N];
        ArrayList<Integer>[] arr = new ArrayList[N+1];
        cnt = new int[N+1];
        for(int i=1;i<=N;i++) {
            arr[i] = new ArrayList<Integer>();
        }
        int before = 0;
        int after = 0;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            before = Integer.parseInt(st.nextToken());
            after = Integer.parseInt(st.nextToken());
            arr[before].add(after);
            cnt[after]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++) {
            if(cnt[i] == 0) {
                queue.add(i);
            }
        }
        while(!queue.isEmpty()) {
            int num = queue.poll();
            sb.append(num+ " ");
            for(int i=0; i<arr[num].size();i++) {
                int temp = arr[num].get(i);
                cnt[temp]--;
                if(cnt[temp] == 0) {
                    queue.add(temp);
                }
            }
        }
        System.out.println(sb);
    }

}
