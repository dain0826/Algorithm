package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Swea_1251 {
    static class Vertex implements Comparable<Vertex>{
        int no;
        long len;
        public Vertex(int no, long len) {
            super();
            this.no = no;
            this.len = len;
        }
        @Override
        public int compareTo(Vertex o) {
            return Long.compare(this.len, o.len);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=T; tc++) {
            int N = Integer.parseInt(br.readLine());
            boolean[] visited = new boolean[N];
            Long[][] adjMatrix = new Long[N][N];
            int[] X = new int[N];
            int[] Y = new int[N];
            Long[] minLen = new Long[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                X[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                Y[i] = Integer.parseInt(st.nextToken());
            }
            double E = Double.parseDouble(br.readLine());
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(i!=j) {
                        adjMatrix[i][j] = (long)(Math.pow(X[i]-X[j], 2) + Math.pow(Y[i]-Y[j],2));
                    }
                }
            }
            PriorityQueue<Vertex> queue = new PriorityQueue<>();
            Arrays.fill(minLen, Long.MAX_VALUE);
            minLen[0] = (long) 0;
            long result = 0; //비용
            queue.offer(new Vertex(0,minLen[0]));
            int c=0;
            while(!queue.isEmpty()) {
                //step 1 : 비트리 정점 중 최소간선비용의 정점 찾기
                Vertex minVertex = queue.poll();
                if(visited[minVertex.no]) continue; //이미 포함되었다면 continue

                result += minVertex.len; //간선 비용 누적
                visited[minVertex.no] = true; //트리 정점에 포함
                if(++c == N) break;

                //step 2 : 새롭게 트리 정점에 확장된 정점 기준으로 비트리 정점들과의 간선비용 고려해서 최적으로 업데이트
                for(int i=0; i<N;i++) {
                    if(!visited[i] && adjMatrix[minVertex.no][i] != 0 && adjMatrix[minVertex.no][i] < minLen[i]) { //비트리정점이면서 나랑 인접해있다면, 그리고 유리하다면
                        minLen[i] = adjMatrix[minVertex.no][i]; //갱신. 갱신만하는거지 트리에 포함할지는 확정되지 않았음
                        queue.offer(new Vertex(i, minLen[i]));
                    }
                }
            }

            result = (long)Math.round(result*E);
            System.out.println("#" + tc + " " + result);
        }
    }

}