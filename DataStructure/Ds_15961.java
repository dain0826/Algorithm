package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ds_15961 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken()); //회전 초밥벨트에 놓인 접시의 수
        int d=Integer.parseInt(st.nextToken()); //초밥의 가짓수
        int k=Integer.parseInt(st.nextToken()); //연속해서 먹는 접시 수
        int c=Integer.parseInt(st.nextToken()); //쿠폰 번호
        int[] sushi = new int[N]; //회전 초밥벨트에 놓인 초밥
        int[] check = new int[d+1]; //먹게 되는 초밥의 종류에 따른 갯수 체크

        for(int i=0;i<N;i++) {
            sushi[i]=Integer.parseInt(br.readLine());
        }

        int answer=1; //쿠폰으로 먹는 초밥 1개를 초기값으로
        check[c]++; //쿠폰으로 먹는 초밥의 종류 +1
        for(int i=0;i<k;i++) { //처음 k개 초밥을 탐색
            if(check[sushi[i]]==0) answer++;
            check[sushi[i]]++;
        }

        int cnt=answer;
        for(int i=1;i<N;i++) { // 그다음 초밥부터
            int pop = sushi[i-1]; //이전 초밥 제거
            check[pop]--;
            if(check[pop]==0) cnt--;

            int add = sushi[(i+k-1)%N]; //추가된 초밥
            if(check[add]==0) cnt++;
            check[add]++;

            answer = Math.max(answer,cnt); //max값 업데이트
        }

        System.out.println(answer);
    }

}