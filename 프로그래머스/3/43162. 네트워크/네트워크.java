import java.util.*;

class Solution {
    static boolean[] visited;
    static ArrayList<Integer>[] arr;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        arr = new ArrayList[n];
        for(int i=0; i<n; i++){
            arr[i]= new ArrayList<Integer>();
        }
        for(int i=0; i<n;i++){
            for(int j=0; j<n; j++){
                if(i!=j && computers[i][j] == 1){
                    arr[i].add(j);
                }
            }
        }
        visited = new boolean[n];
        for(int i=0; i<n; i++){
            if(!visited[i]){
                answer++;
                DFS(i);
            }
        }
        return answer;
    }
    public static void DFS(int comp){
       if(visited[comp]){
           return;
       }
        visited[comp] = true;
        for(int i : arr[comp]){
            DFS(i);
        }
    }
}