package DataStructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ds_1158{

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = scan.nextInt();
        int K = scan.nextInt();
        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<=N; i++) {
            queue.offer(i); //큐에 1부터 n까지 넣어준다.
        }
        sb.append("<");
        while(queue.size()!=1) { //큐에 1개만 남을 때까지
            for(int i=1; i<K; i++) {
                queue.offer(queue.poll()); //앞에 k-1개를 뒤에 다시 넣어준다.
            }
            sb.append(queue.poll() + ", "); //앞에서 k-1개를 뺐으므로 k번째 수를 출력
        }
        sb.append(queue.poll() + ">");
        System.out.println(sb);
    }
}
