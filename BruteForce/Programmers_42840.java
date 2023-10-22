package BruteForce;

import java.util.*;

class Programmers_42840 {
    public int[] solution(int[] answers) {

        int[] a_answer = {1,2,3,4,5};
        int[] b_answer = {2,1,2,3,2,4,2,5};
        int[] c_answer = {3,3,1,1,2,2,4,4,5,5};
        int[] score = new int[3];

        for(int i=0; i<answers.length;i++) {
            if(answers[i] == a_answer[i%5])
                score[0]++;
            if(answers[i] == b_answer[i%8])
                score[1]++;
            if(answers[i] == c_answer[i%10])
                score[2]++;
        }

        List<Integer> winner = new ArrayList<>();
        int max_score = Math.max(score[0], Math.max(score[1],score[2]));
        if(score[0] == max_score){
            winner.add(1);
        }
        if(score[1] == max_score){
            winner.add(2);
        }
        if(score[2] == max_score){
            winner.add(3);
        }
        int[] answer = new int[winner.size()];
        for(int i=0;i<answer.length;i++) {
            answer[i] = winner.get(i);
        }
        return answer;
    }
}