package Greedy;

import java.util.Scanner;

public class G_1541 {
    public static void main(String[] args) {
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        String origin = sc.nextLine();
        String[] str = origin.split("-");

        for(int i=0; i<str.length; i++) {
            int temp = mySum(str[i]);
            if(i==0)
                answer += temp;
            else
                answer -= temp;
        }
        System.out.println(answer);
    }

    static int mySum(String a) {
        int sum = 0;
        String temp[] = a.split("[+]");
        for(int i=0; i<temp.length; i++) {
            sum += Integer.parseInt(temp[i]);
        }
        return sum;
    }
}
