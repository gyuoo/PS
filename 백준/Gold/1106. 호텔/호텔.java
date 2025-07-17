import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken()), ans = 0;
        int[] cost  = new int[N], guest = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i]  = Integer.parseInt(st.nextToken());
            guest[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[C+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            int c = cost[i], g = guest[i];
            for (int j = 1; j <= C; j++) {
                int prev = (0 <= j-g ? dp[j-g] : 0);
                dp[j] = Math.min(dp[j], prev+c);
            }
        }
        System.out.print(dp[C]);
    }
}