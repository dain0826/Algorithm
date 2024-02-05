package DataStructure;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Ds_2493{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<Integer>();
        st = new StringTokenizer(br.readLine());

        int num= Integer.parseInt(st.nextToken()); //첫번째 탑을 먼저 세팅해준다.
        stack.push(num);
        int max = num;
        int m_idx = 1; //제일 높은 탑의 인덱스
        int[] s_idx = new int[N]; //스택에 들어가있는 탑들의 순번을 담은 배열
        int cnt = 0; //cnt개의 탑이 스택에 들어가있음
        s_idx[cnt] = 1; //순번[0] 은 첫번째 탑
        sb.append(0);

        for(int i=2; i<=N; i++) { //두번째 탑부터 진행
            sb.append(" ");
            num = Integer.parseInt(st.nextToken());
            if(!stack.isEmpty()) {
                if(max <= num) { //최고층 탑보다 높은 탑이라면
                    sb.append(0);
                    max = num; //max 값 바꿔주고
                    m_idx = i; //인덱스 값 바꿔준다
                }
                else if(stack.peek() >= num) { //제일 상위의 스택 탑보다 높이가 낮다면
                    sb.append(s_idx[cnt]); //그 탑의 순번을 출력
                }
                else{ //제일 상위의 스택 탑보다 높이가 높다면
                    while(stack.peek()<num) { //더 높은 탑이 있기전까지는 지금 탑이 제일 높으므로
                        stack.pop(); // 스택에 있는 탑을 빼주고
                        cnt--; //개수도 줄여준다
                    }
                    sb.append(s_idx[cnt]); //더 높은 탑이 나왔으므로 그 탑의 순번을 출력
                }
                stack.push(num); //스택에 탑을 넣어주고
                cnt++; //갯수를 늘려준다.
                s_idx[cnt] = i; //순번을 담아준다.
            }
        }
        System.out.println(sb);
    }
}
