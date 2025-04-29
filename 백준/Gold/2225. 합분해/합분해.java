import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[K+1][N+1];
        Arrays.fill(dp[1], 1);
        for (int i = 2; i <= K; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= N; j++) {
                dp[i][j] = (dp[i][j-1]+dp[i-1][j])%1_000_000_000;
            }
        }
        System.out.print(dp[K][N]);
    }
}