package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bs_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //나무의 수
        int M = Integer.parseInt(st.nextToken()); //집으로 가져가려고 하는 나무의 길이
        int[] tree = new int[N];
        int min = 0;
        int max = Integer.MIN_VALUE;
        int mid = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            tree[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, tree[i]);
        }

        while(min<max) {
            mid = (min + max)/2;
            long sum = 0;
            for(int i=0; i<N; i++){
                if(tree[i]>mid){
                    sum += tree[i]-mid;
                }
            }
            if(sum<M){
                max = mid;
            }
            else{
                min = mid + 1;
            }
        }
        System.out.println(min-1);
    }
}


