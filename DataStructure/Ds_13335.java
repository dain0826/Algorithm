package DataStructure;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ds_13335 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Queue<Integer> bridge = new LinkedList<>(); //다리위를 지나는 트럭을 넣을 큐
        for(int i=0; i<W; i++){
            bridge.add(0); // 다리 길이만큼 0을 넣어준다
        }
        int weight=0;
        int time=0;

        st = new StringTokenizer(br.readLine());

        int truck= Integer.parseInt(st.nextToken());
        while(!bridge.isEmpty()){ //다리위에 트럭이 없을 때까지
            time++;
            weight -= bridge.poll(); //다리위를 지나는 트럭 무게에서 하나씩 빼주기

            if(weight + truck <= L){ //최대 하중을 넘지 않으면
                bridge.add(truck); //다리위에 트럭을 올려주고
                weight += truck; //무게 더해주고
                if(--N == 0) break; //남은 다리 수도 하나씩 줄여준다.

                truck = Integer.parseInt(st.nextToken());
            }
            else{
                bridge.add(0); //다리위에 트럭을 올리지 못하면 0을 넣어준다.
            }
        }
        time += bridge.size(); //다리 위에 남은 트럭 수까지 시간에 포함
        System.out.println(time);
    }
}