package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class Bs_1920 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] A = new int[N];
        for(int i=0; i<N; i++) {
            A[i] = scan.nextInt();
        }
        Arrays.sort(A);
        int M = scan.nextInt();
        for(int i=0; i<M;i++) {
            boolean find = false;
            int target = scan.nextInt();
            int start = 0;
            int end = A.length -1;

            while(start <= end) {
                int mid = (start + end)/2;
                if (target == A[mid]) {
                    find = true;
                    break;
                } else if (target > A[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            if (find) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
