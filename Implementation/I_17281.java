package Implementation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class I_17281{
    static int N, answer;
    static int[] order = new int[10];
    static int[][] result;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        result = new int[N][10]; //각 선수가 각 이닝에서 얻는 결과
        visited = new boolean[10];
        order = new int[10];//순서 1~9
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=9; j++) {
                result[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        order[4] = 1; //1번 선수는 4번 타자
        visited[4] = true; //4번 자리는 결정됨
        perm(2);
        System.out.println(answer);

    }
    public static void play() {
        int score = 0;
        int player = 1; //타자번호
        for(int i=0; i<N; i++) { //이닝 N회
            int out = 0; //이닝당 아웃 수
            int[] base = new int[4]; //1루2루3루
            while(out!=3) { //out이 3회되면 이닝 종료
                if(result[i][order[player]] == 0) { //아웃
                    out++;
                }
                else if(result[i][order[player]] == 1){ //안타
                    if(base[3]!=0) {
                        score++;
                    }
                    base[3] = base[2];
                    base[2] = base[1];
                    base[1] = order[player];
                }
                else if(result[i][order[player]] == 2){ //2루타
                    if(base[3]!=0) {
                        score++;
                    }
                    if(base[2]!=0) {
                        score++;
                    }
                    base[3] = base[1];
                    base[2] = order[player];
                    base[1] = 0;
                }
                else if(result[i][order[player]] == 3){ //3루타
                    if(base[3]!=0) {
                        score++;
                    }
                    if(base[2]!=0) {
                        score++;
                    }
                    if(base[1]!=0) {
                        score++;
                    }
                    base[3] = order[player];
                    base[2] = 0;
                    base[1] = 0;

                }
                else if(result[i][order[player]] == 4) { //홈런
                    if(base[3]!=0) {
                        score++;
                    }
                    if(base[2]!=0) {
                        score++;
                    }
                    if(base[1]!=0) {
                        score++;
                    }
                    score++;
                    base[3] = 0;
                    base[2] = 0;
                    base[1] = 0;
                }
                player++;
                if(player>9) player = 1;
            }
        }
        answer = Math.max(score, answer);

    }

    public static void perm(int cnt) {
        if(cnt == 10) { //9명의 순서가 다 정해졌다면
            play();
            return;
        }
        for(int i=1; i<=9; i++) {
            if(!visited[i]) {
                order[i] = cnt;
                visited[i] = true;
                perm(cnt+1);
                visited[i] = false;
            }
        }
    }

}
