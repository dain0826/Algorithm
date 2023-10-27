package DataStructure;

import java.util.*;

public class Programmers_42576 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String,Integer> hm = new HashMap<>();
        for(String p : participant) {
            hm.put(p, hm.getOrDefault(p,0)+1);
        }
        for(String c : completion) {
            hm.put(c, hm.get(c)-1);
        }
        for(String h : hm.keySet()) {
            if(hm.get(h) != 0) {
                answer = h;
                break;
            }
        }
        return answer;
    }
}
