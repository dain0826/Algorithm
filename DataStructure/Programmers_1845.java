package DataStructure;

import java.util.*;

public class Programmers_1845 {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> numset = new HashSet<>();

        for(int i : nums) {
            numset.add(i);
        }
        answer = numset.size();
        if(answer > nums.length / 2)
            answer = nums.length / 2 ;
        return answer;
    }
}