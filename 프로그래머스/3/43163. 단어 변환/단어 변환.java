import java.util.*;

public class StringAndIdx {
    String str;
    int idx;
    
    StringAndIdx(String str, int idx) {
        this.str = str;
        this.idx = idx;
    }
}

class Solution {
    static boolean[] visited;
    static int answer=0;
    static int[] dis;
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        dis = new int[words.length + 1];
        if(Arrays.asList(words).contains(target)) {
            BFS(begin, target, words);
            return answer;
        }
        else {
            return 0;
        }
        
    }
    static void BFS(String begin, String target, String[] words){
        Queue<StringAndIdx> queue = new LinkedList<>();
        queue.add(new StringAndIdx(begin,0));
        
        while(!queue.isEmpty()){
            StringAndIdx now = queue.poll();
            if(now.str.equals(target)) {
                return;
            }
            for(int i=0; i<words.length; i++) {
                int cnt = 0;
                String next = words[i];
                if(!visited[i]){
                    for(int j=0;j<now.str.length();j++) {
                        if(next.charAt(j) == now.str.charAt(j)) {
                            cnt++;
                        }
                    }
                    if(cnt == now.str.length() -1) {
                        visited[i] = true;
                        queue.add(new StringAndIdx(words[i],i+1));
                        dis[i+1] = dis[now.idx] + 1;
                        answer = dis[i+1];
                    }
                }
            }
        }
        
    }
}