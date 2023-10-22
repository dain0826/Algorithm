package Sorting;

import java.util.*;

public class Programmers_42748 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0; i<commands.length; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1] - 1;
            int find = commands[i][2] - 1;

            int[] temp = new int[end - start + 1];
            for(int j=0; j<temp.length;j++) {
                temp[j] = array[start++];
            }
            Arrays.sort(temp);
            answer[i] = temp[find];
        }
        return answer;
    }
}
