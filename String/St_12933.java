package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class St_12933 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] arr = new int[6];
        int answer = 0;
        if (s.charAt(0)!= 'q' || s.charAt(s.length()-1)!='k' || s.length()%5!=0) {
            System.out.println(-1);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            int n = 0;
            if (s.charAt(i) == 'q') n = 1;
            else if (s.charAt(i) == 'u') n = 2;
            else if (s.charAt(i) == 'a') n = 3;
            else if (s.charAt(i) == 'c') n = 4;
            else if (s.charAt(i) == 'k') n = 5;
            if (n!=1 && arr[n - 1] == 0) {
                System.out.println(-1);
                return;
            }
            arr[n]++;
            arr[n-1]--;
            answer = Math.max(answer, arr[1] + arr[2] + arr[3] + arr[4]);
        }

        System.out.println(answer);
    }
}