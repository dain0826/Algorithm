package DataStructure;

import java.util.Scanner;
import java.util.Stack;

public class Ds_9012 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.nextLine();
        for(int i=0; i<N;i++){
            boolean answer = true;
            String s = scan.nextLine();
            Stack<Character> st = new Stack<>();
            for(int j=0; j<s.length(); j++){
                if(s.charAt(j) == '('){
                    st.push('(');
                }
                if(s.charAt(j) ==')'){
                    if(st.size()==0){
                       answer = false;
                       break;
                    }
                    else{
                        st.pop();
                    }
                }
            }
            if(st.size() != 0){
                answer = false;
            }
            System.out.println(answer ? "YES" : "NO");
        }
    }
}
