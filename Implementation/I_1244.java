package Implementation;
import java.util.Scanner;

public class I_1244 {
    static int[] light;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb= new StringBuilder();
        int n = scan.nextInt(); //스위치 개수
        light = new int[n+1];
        for(int i=1; i<=n; i++) {
            light[i] = scan.nextInt(); //스위치 초기 상태 받아옴
        }
        int s = scan.nextInt(); //학생 수
        for(int i=0; i<s; i++) {
            int gender = scan.nextInt(); //성별
            int num = scan.nextInt(); //번호 부여
            if(gender == 1){ //남학생이면
                for(int j=num; j<=n; j+=num) {
                    light[j] = (light[j]==1) ? 0 : 1; //스위치 전환
                }
            }
            else if(gender ==2) { //여학생이면
                light[num] = (light[num]==1) ? 0 : 1; //해당 학생의 스위치를 전환
                for(int j=1; j<=Math.min(num-1, n-num); j++) {
                    if(light[(num-j)]  != light[(num + j)]) { //대칭구조이면
                        break;
                    }
                    else {
                        light[num-j] = (light[num-j]==1) ? 0 : 1;//왼쪽 스위치 전환
                        light[num+j] = (light[num+j]==1) ? 0 : 1; //오른쪽 스위치 전환
                    }
                }
            }
        }
        for(int i=1; i<=n; i++) {
            sb.append(light[i]).append(" ");
            if(i % 20 == 0) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}