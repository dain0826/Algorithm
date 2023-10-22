package BruteForce;
import java.util.*;

public class Programmers_86491 {
    public int solution(int[][] sizes) {
        int answer = 0;
        int max_w = 0;
        int max_h = 0;
        for(int i=0; i<sizes.length;i++) {
            int w = Math.max(sizes[i][0],sizes[i][1]);
            int h = Math.min(sizes[i][0],sizes[i][1]);
            max_w = Math.max(max_w, w);
            max_h = Math.max(max_h, h);
        }
        answer = max_w * max_h;
        return answer;
    }
}
