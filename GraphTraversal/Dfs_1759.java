package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Dfs_1759{
    static int L,C;
    static char[] alp;
    static char[] pw;
    static StringBuffer sb;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuffer();
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        alp = new char[C]; //C개의 문자열을 담음
        pw = new char[L]; //추측한 패스워드를 담음
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++) {
            alp[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(alp); //오름차순으로 정렬
        check(0,0);
        System.out.println(sb);
    }

    public static void check(int start, int depth) {
        if(depth == L) { //L개의 알파벳이 정해졌다면
            if(isPossible(pw)) { //pw조건을 충족하는지 검사
                sb.append(String.valueOf(pw)+"\n");
            }
            return;
        }
        for(int i = start; i<C; i++) { //pw의 depth에 alp 추가하기
            pw[depth]=alp[i];
            check(i+1, depth+1);
        }
    }

    public static boolean isPossible(char[] password) { //암호 조건 확인
        int mo = 0; //모음 개수
        int ja = 0; //자음 개수
        for(int i=0; i<L; i++) {
            if(password[i] == 'a' || password[i] == 'e'|| password[i] == 'i' || password[i] == 'o' || password[i] == 'u') { //모음이면
                mo++;
            }
            else ja++; //자음이면
        }
        if(mo>=1 && ja>=2) return true; //모음1개 이상, 자음 2개이상이라면 true 반환
        else return false;
    }

}
