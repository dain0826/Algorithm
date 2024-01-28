package Greedy;

import java.util.Scanner;

public class G_2839 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int cnt = 0;
        while(N >0){
            if(N%5 == 0){
                cnt += N/5;
                System.out.println(cnt);
                return;
            }
            if(N<3){
                System.out.println(-1);
                return;
            };
            N -= 3;
            cnt++;
        }
        System.out.println(cnt);
    }
}
