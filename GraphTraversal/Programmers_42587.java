package GraphTraversal;

import java.util.*;

public class Programmers_42587 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int size = priorities.length-1;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<priorities.length; i++){
            queue.offer(new int[] {i,priorities[i]});
        }
        Arrays.sort(priorities);

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            if(now[1] == priorities[size-answer]) {
                answer++;
                if(now[0] == location) break;
            }
            else if(now[1] < priorities[size-answer]) {
                queue.offer(now);
            }
        }

        return answer;
    }
}