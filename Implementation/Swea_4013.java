package Implementation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Swea_4013 {
    static int K;
    static int[][] magnetic;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            K = Integer.parseInt(br.readLine());
            LinkedList[] list = new LinkedList[5];
            StringTokenizer st;
            for(int i=1; i<=4; i++) {
                st = new StringTokenizer(br.readLine());
                LinkedList<Integer> l = new LinkedList<>();
                for(int j=0; j<8; j++) {
                    l.add(Integer.parseInt(st.nextToken()));
                }
                list[i] = l;
            }
            for(int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int[] wheel = new int[5];
                wheel[x] = y;

                int dir = y;
                for(int j=x+1; j<=4; j++) {
                    if(list[j].get(6)!=list[j-1].get(2)) {
                        dir = dir * -1;
                        wheel[j] = dir;
                    }
                    else break;
                }
                dir = y;
                for(int j=x-1; j>=1; j--) {
                    if(list[j].get(2)!=list[j+1].get(6)) {
                        dir = dir * -1;
                        wheel[j] = dir;
                    }
                    else break;
                }
                for(int j=1; j<=4; j++) {
                    if(wheel[j]==1) {
                        list[j].addFirst(list[j].pollLast());
                    }
                    else if(wheel[j] == -1) list[j].addLast(list[j].pollFirst());
                }
            }
            int sum=0;
            for(int j=1; j<=4; j++) {
                if((int)list[j].get(0)==1) {
                    sum+=Math.pow(2, j-1);
                }
            }
            System.out.println("#" + t + " " + sum);
        }

    }

}
