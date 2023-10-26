package Implementation;

import java.util.Scanner;

public class I_1157 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine();
        int[] count = new int[26];

        for(int i=0; i<word.length();i++) {
            if(word.charAt(i)>='A' && word.charAt(i)<='Z') {
                count[word.charAt(i) - 'A']++;
            }
            else {
                count[word.charAt(i) - 'a']++;
            }
        }
        int max = 0;
        char ch = '?';
        for(int i=0; i<26;i++) {
            if(max < count[i]) {
                max = count[i];
                ch = (char)(i+65);
            }
            else if(max == count[i]) {
                ch = '?';
            }
        }
        System.out.println(ch);
    }
}
