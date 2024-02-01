package String;
import java.util.Scanner;

public class St_12891 {

    static int[] subPw; //부분문자열에 들어가는 A,C,G,T의 갯수를 담을 배열
    static int[] check; //비밀번호 조건에 맞는 A, C, G, T 의 최소 갯수를 담을 배열
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int S = scan.nextInt();
        int P = scan.nextInt();
        scan.nextLine();
        char[] dna = scan.nextLine().toCharArray(); // dna문자열
        int answer = 0;
        check = new int[4];
        subPw = new int[4];

        for(int i=0; i<4; i++) {
            check[i] = scan.nextInt();
        }
        // 처음 윈도우
        for(int i=0; i<P; i++) {
            if(dna[i] =='A')
                subPw[0]++;
            if(dna[i] == 'C')
                subPw[1]++;
            if(dna[i] == 'G')
                subPw[2]++;
            if(dna[i] == 'T')
                subPw[3]++;
        }
        if(correct()) { //비밀번호 조건을 성립하면
            answer++;
        }

        // 그 다음 윈도우부터
        for(int i=P; i<S; i++) {

            if(dna[i - P] =='A')
                subPw[0]--;
            if(dna[i - P] =='C')
                subPw[1]--;
            if(dna[i - P] =='G')
                subPw[2]--;
            if(dna[i - P] =='T')
                subPw[3]--;

            if(dna[i] =='A')
                subPw[0]++;
            if(dna[i] =='C')
                subPw[1]++;
            if(dna[i] =='G')
                subPw[2]++;
            if(dna[i] =='T')
                subPw[3]++;

            if(correct()) { //비밀번호 조건을 성립하면
                answer++;
            }
        }

        System.out.println(answer);

    }
    private static boolean correct() { //비밀번호 조건에 성립하는지 확인
        for(int i=0; i<4; i++) {
            if(subPw[i] < check[i])
                return false;
        }
        return true;
    }

}