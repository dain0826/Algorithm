package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G_1700 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] order = new int[K];
        int[] tab = new int[N];

        int answer = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++){
            order[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<K; i++){
            int now = order[i]; //현재 전기용품 번호
            boolean isPlugged = false; //꽂혀있는지
            for(int j=0; j<N; j++){
                if(tab[j] == now){ //같은 전기용품 번호를 발견하면
                    isPlugged = true; //꽂혀있음 표시
                    break;
                }
            }
            if(isPlugged) continue;

            boolean canPlugged = false; //꽂을 수 있는지
            for(int j=0; j<N; j++){
                if(tab[j] == 0){ //빈 칸이 있다면
                    tab[j] = now; //꽂아주고
                    canPlugged = true; //꽂을 수 있음 표시
                    break;
                }
            }
            if(canPlugged) continue;

            int maxLaterIndex = -1; //가장 늦게 사용되는 전기용품의 순서
            int unplug = -1; //가장 늦게 사용되는 전기용품이 꽂혀있는 멀티탭
            for(int j=0; j<N; j++){ //각 탭에서
                int lastIndex = Integer.MAX_VALUE; //각 탭에 꽂혀있는 전기용품의 바로 다음 순서
                for(int k=i+1; k<K; k++){
                    if(order[k] == tab[j]){
                        lastIndex = k;
                        break;
                    }
                }
                if(lastIndex > maxLaterIndex){
                    maxLaterIndex = lastIndex;
                    unplug = j;
                }
            }
            tab[unplug] = now;
            answer++;

        }
        System.out.println(answer);
    }
}
