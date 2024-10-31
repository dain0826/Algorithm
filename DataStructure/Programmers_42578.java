package DataStructure;

import java.util.*;

public class Programmers_42578 {
    public int solution(String[][] clothes) {
        Map<String, Integer> kindOfCloth = new HashMap<>();
        for(String[] c : clothes){
            String type = c[1];
            kindOfCloth.put(type, kindOfCloth.getOrDefault(type,0)+1);
        }
        int answer = 1;
        for(int count : kindOfCloth.values()){
            answer *= (count + 1);
        }
        return answer-1;
    }
}

