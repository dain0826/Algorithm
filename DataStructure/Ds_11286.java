package DataStructure;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Ds_11286 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int num = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int a = Math.abs(o1);
                int b = Math.abs(o2);
                if(a>b) return 1;
                else if(a<b) return -1;
                else {
                    if(o1>o2) return 1;
                    else if(o1<o2) return -1;
                    else return 0;
                }
            }
        });
        for(int i=0; i<N; i++) {
            num = scan.nextInt();
            if(num != 0) {
                pq.offer(num);
            }
            else {
                if(pq.isEmpty()) {
                    System.out.println(0);
                }
                else {
                    System.out.println(pq.poll());
                }
            }
        }
    }
}

