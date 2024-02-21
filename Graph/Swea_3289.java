package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_3289{
    static int n, m;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            System.out.print("#" + tc + " ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            parent = new int[n+1];

            for(int i=1; i<=n; i++) {
                parent[i] = i;
            }
            for(int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());
                int op = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if(op == 0) {
                    union(a,b);
                }
                else if(op == 1) {
                    if(find(a) == find(b)) {
                        System.out.print(1);
                    }
                    else
                        System.out.print(0);
                }
            }
            System.out.println();
        }

    }
    public static int find(int num) {
        if(parent[num] == num) { //해당 번호의 부모가 자기 자신이라면
            return num; //자기자신 반환
        }
        return find(parent[num]); //부모의 부모 찾기
    }
    public static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y) return false; //이미 같은 집합에 속해 있음
        parent[Math.max(x, y)] = Math.min(x, y); //더 작은 번호가 부모가 되도록 함
        return true;
    }

}

