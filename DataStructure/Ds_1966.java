package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Ds_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            LinkedList<int[]> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                queue.add(new int[] {i, Integer.parseInt(st.nextToken())});
            }
            int cnt = 0;
            while(!queue.isEmpty()){
                int[] now = queue.poll();
                boolean flag = true;
                for(int i=0; i<queue.size(); i++) {
                    if(queue.get(i)[1]> now[1]) { //중요도가 더 높은 프린트가 있다면
                        queue.add(now);
                        for (int j = 0; j < i; j++) {
                            queue.add(queue.poll());
                        }
                        flag = false;
                        break;
                    }
                }
                if(!flag){
                    continue;
                }
                cnt++;
                if(now[0] == M){
                    break;
                }
            }
            System.out.println(cnt);
        }
    }

}
