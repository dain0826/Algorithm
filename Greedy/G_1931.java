package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class G_1931 {
    static class Meeting implements Comparable<Meeting>{
        int start,end;
        public Meeting(int start, int end){
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Meeting o){
            if(this.end == o.end){
                return this.start - o.start;
            }
            return this.end - o.end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Meeting[] time = new Meeting[N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(time);

        int answer = 0;
        int finish = 0;
        for(int i=0; i<N; i++){
            if(finish <= time[i].start){
                answer++;
                finish = time[i].end;
            }
        }
        System.out.println(answer);
    }
}
