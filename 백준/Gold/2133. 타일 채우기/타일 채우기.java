import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), ans = 0;
        int[] dp = new int[Math.max(3, N+1)];
        if (N%2 == 0) {
            dp[0] = 1;
            dp[2] = 3;
            for (int i = 4; i <= N; i += 2) {
                dp[i] = dp[i-2]*3 + 2;
                for (int j = i-4; 2 <= j; j -= 2) {
                    dp[i] += dp[j]*2;
                }
            }
            ans = dp[N];
        }
        System.out.print(ans);
    }
}