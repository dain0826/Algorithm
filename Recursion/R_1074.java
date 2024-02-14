package Recursion;
import java.util.Scanner;

public class R_1074{
    static int N, r, c;
    static int cnt = -1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        recur(r,c, (int) Math.pow(2, N));
        System.out.println(cnt);
    }
    public static void recur(int x, int y, int len) { //len은 한변의길이
        if(len == 1) {
            cnt++;
            return;
        }
        if(x<(len/2) && y<(len/2)) { //왼쪽 윗 부분
            recur(x,y,(len/2));
        }
        else if(x<(len/2) && y>=(len/2)) { //오른쪽 윗 부분
            cnt += len*len/4;
            recur(x,y-(len/2),(len/2));
        }
        else if(x>=(len/2) && y<(len/2)) { //왼쪽 아랫부분
            cnt += (len*len/4)*2;
            recur(x-(len/2),y,(len/2));
        }
        else { //오른쪽 아랫부분
            cnt += (len*len/4)*3;
            recur(x-(len/2),y-(len/2),(len/2));
        }
    }
}
