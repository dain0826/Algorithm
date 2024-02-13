package Implementation;

import java.util.Arrays;
import java.util.Scanner;

public class I_16435{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        int fruit[] = new int[N];

        for(int i=0; i<N; i++) {
            fruit[i] = sc.nextInt();
        }
        Arrays.sort(fruit);
        for(int i : fruit) {
            if(L >= i) {
                L++;
            }
            else
                break;
        }
        System.out.println(L);
    }
}
