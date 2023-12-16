import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int fee1 = scan.nextInt();
        int fee2 = scan.nextInt();
        int fee3 = scan.nextInt();
        int inout[][] = new int[3][2];

        for(int i=0; i<3;i++){
            for(int j=0;j<2; j++) {
                inout[i][j] = scan.nextInt();
            }
        }
        int count = 0;
        boolean[] start = new boolean[3];
        boolean[] end = new boolean[3];
        int sum = 0;

        for(int i=1; i<=100;i++) {
            for(int j=0; j<3;j++) {
                if(!start[j] && inout[j][0]== i) {
                    count++;
                    start[j] = true;
                }
                if(!end[j] && inout[j][1]== i) {
                    count--;
                    end[j] = true;
                }
            }
            if(count == 1){
                sum += count * fee1;
            }
            else if(count ==2){
                sum += count * fee2;
            }
            else if(count == 3){
                sum += count * fee3;
            }
            if(end[0] && end[1] && end[2]){
                System.out.println(sum);
                return;
            }

        }
    }
}