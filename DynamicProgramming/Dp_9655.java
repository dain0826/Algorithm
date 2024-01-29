package DynamicProgramming;

import java.util.Scanner;

public class Dp_9655 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] D = new int[1001];
        D[1] = 1;
        D[2] = 0;
        D[3] = 1;
        for(int i = 4; i<= N; i++){
            if(D[i-1] == 1 && D[i-3] == 1){
                D[i] = 0;
            }
            else D[i] = 1;
        }
        System.out.println(D[N]==1 ? "SK" : "CY");
    }
}
