package DataStructure;

import java.util.Scanner;
import java.util.Stack;

public class Ds_1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //수열의 개수
        int[] A = new int[N];
        for(int i = 0; i< N; i++) {
            A[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        StringBuffer bf = new StringBuffer();
        int num = 1; //자연수
        boolean result = true; //출력 여부
        for(int i = 0; i<N; i++) {
            int su = A[i];
            if(su >= num) {
                while(su >= num) {
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            }
            else{
                int n = stack.pop();
                if(n > su){
                    System.out.println("No");
                    result = false;
                    break;
                }
                else {
                    bf.append("-\n");
                }
            }
        }
        if(result) System.out.println(bf.toString());
    }
}
