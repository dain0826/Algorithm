package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class M_5607{
    static final long mod = 1234567891;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            long[] fact = new long[N+1];
            fact[1] = 1;
            for(int i=2; i<=N; i++) {
                fact[i] = (fact[i-1] * i) % mod;
            }
            long bottom = fact[R] * fact[N-R] % mod;
            bottom = fermat(bottom, mod-2);
            System.out.println("#"+ t + " " + fact[N] * bottom % mod);
        }
    }

    private static long fermat(long a, long b) { //거듭제곱 구하기
        if(b==0) return 1;
        long tmp = fermat(a, b/2);
        long ret = (tmp*tmp) % mod;
        if(b%2==0) return ret;
        else return ret*a % mod;
    }

}
