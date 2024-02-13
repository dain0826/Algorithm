package Implementation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class I_17406{
    static int[][] delta = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int N, M, K, min;
    static int[][] arr, temp; //원본배열, 복사 배열
    static List<int[]> list = new ArrayList<>();
    static int order[][]; //회전연산을 담을 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][M + 1]; //인덱스 맞추기 위해 행, 열 모두 size +1
        order = new int[K][3]; //r,c,s를 담을 K개의 배열
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            order[i][0] = Integer.parseInt(st.nextToken()); //r
            order[i][1] = Integer.parseInt(st.nextToken()); //c
            order[i][2] = Integer.parseInt(st.nextToken()); //s
        }
        min = Integer.MAX_VALUE;
        int numbers[] = new int[K];
        boolean visited[] = new boolean[K];
        permutation(0, numbers, visited);
        for (int i = 0; i < list.size(); i++) {
            temp = new int[N + 1][M + 1];
            for (int r = 1; r <= N; r++) {
                for (int c = 1; c <= M; c++) {
                    temp[r][c] = arr[r][c];
                }
            }
            int[] rotateInfo = list.get(i);
            for (int j : rotateInfo) {
                turn(order[j][0], order[j][1], order[j][2]);
            }
            rowMin();
        }
        System.out.println(min);
    }
    public static void permutation(int cnt, int[] numbers, boolean[] visited) { //회전 연산 순서
        if (cnt == K) {
            list.add(numbers.clone());
        }
        for (int i = 0; i < K; i++) {
            if (!visited[i]) {
                numbers[cnt] = i;
                visited[i] = true;
                permutation(cnt + 1, numbers, visited);
                visited[i] = false;
            }
        }
    }
    public static void turn(int r, int c, int s) { //시계방향으로 회전
        int size = 2*s + 1;
        for (int i = 0; i < size / 2; i++) {
            int save = temp[r-s+i][c-s+i];
            int x = r-s+i;
            int y = c-s+i;
            for (int j = 0; j < 4; j++) {
                while (true) {
                    int nx = x + delta[j][0];
                    int ny = y + delta[j][1];
                    if (nx < r-s + i || nx > r+s - i || ny < c-s + i || ny > c+s - i)
                        break;
                    temp[x][y] = temp[nx][ny];
                    x = nx;
                    y = ny;
                }
            }
            temp[r-s+i][c-s+i + 1] = save;
        }
    }
    public static void rowMin() { //행에 있는 모든 수의 합 중 최솟값
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= M; j++) {
                sum += temp[i][j];
            }
            min = Math.min(min, sum);
        }
    }
}

