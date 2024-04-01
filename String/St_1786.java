package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class St_1786{
    static int answer;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        String pattern = br.readLine();
        list = new ArrayList<>();
        KMP(text, pattern);
        System.out.println(answer);
        for(int i=0; i<answer; i++) {
            System.out.println(list.get(i));
        }


    }
    public static int[] headtail(String p) {
        int[] ht = new int[p.length()];
        int j = 0; //헤드와 테일 일치하는 길이
        for(int i=1; i<p.length(); i++) { //i는 현재 위치
            while(j>0 && p.charAt(i) != p.charAt(j)) {
                j = ht[j-1]; //
            }
            if(p.charAt(i) == p.charAt(j)) ht[i]= ++j;
        }
        return ht;
    }


    public static void KMP(String t, String p) {
        int[] ht = headtail(p);
        int j = 0;
        for(int i=0; i<t.length(); i++) {
            while(j>0 && t.charAt(i)!=p.charAt(j)) {
                j = ht[j-1];
            }
            if(t.charAt(i) == p.charAt(j)) {
                if(j == p.length()-1) {
                    ++answer;
                    list.add(i-j+1);
                    j = ht[j];
                }
                else
                    j++;
            }
        }
    }

}

