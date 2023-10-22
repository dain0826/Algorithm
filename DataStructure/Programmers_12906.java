package DataStructure;

import java.util.*;

public class Programmers_12906 {
    public int[] solution(int []arr) {
        Stack<Integer> st = new Stack<>();
        for(int i : arr) {
            if(st.isEmpty() || st.peek() != i){
                st.push(i);
            }
        }
        int[] answer = new int[st.size()];
        for(int j=(st.size()-1); j>=0; j--){
            answer[j] = st.pop();
        }

        return answer;
    }
}
