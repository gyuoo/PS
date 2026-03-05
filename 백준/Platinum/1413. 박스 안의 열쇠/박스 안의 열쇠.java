import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        long[][] dp = new long[N+1][N+1];
        dp[1][1] = 1;
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i-1][j-1]+(long)(i-1)*dp[i-1][j];
            }
        }
        long numerator = 0, denominator = 0;
        for (int j = 1; j <= M; j++) numerator += dp[N][j];
        for (int j = 1; j <= N; j++) denominator += dp[N][j];
        long g = gcd(numerator, denominator);
        System.out.print(sb.append(numerator/g).append('/').append(denominator/g));
    }

    static long gcd(long a, long b) {
        while (b != 0) {
            long r = a%b;
            a = b;
            b = r;
        }
        return a;
    }
}