package DataStructure;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Swea_1228
{
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            LinkedList<Integer> pw = new LinkedList<>();
            int len = Integer.parseInt(br.readLine()); //원본 암호문의 길이
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<len; i++){
                pw.add(Integer.parseInt(st.nextToken())); //LinkedList에 원본 암호문 넣어주기
            }
            int cnt = Integer.parseInt(br.readLine()); //명령어의 개수
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<cnt; i++) {
                st.nextToken();
                int x = Integer.parseInt(st.nextToken()); //x의 위치
                int y = Integer.parseInt(st.nextToken()); //y개의 숫자

                for(int j=0; j<y; j++){
                    pw.add(x++,Integer.parseInt(st.nextToken())); //x의 위치다음에 y개의 숫자 삽입
                }
            }
            System.out.print("#" + test_case + " ");
            for(int i=0; i<10; i++){
                System.out.print(pw.get(i) + " ");
            }
            System.out.println();
        }
    }
}