package GraphTraversal;

import java.util.*;

public class Programmers_43165 {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        DFS(numbers, target, 0, 0);
        return answer;
    }

    public void DFS(int [] numbers, int target, int depth, int sum) {
        if(numbers.length == depth) {
            if(target == sum){
                answer++;
            }
        }
        else {
            DFS(numbers, target, depth+1, sum+numbers[depth]);
            DFS(numbers, target, depth+1, sum-numbers[depth]);
        }
    }
}
