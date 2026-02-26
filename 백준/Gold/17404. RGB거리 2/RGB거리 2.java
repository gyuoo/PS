import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }
        int ans = 1_000_000;
        for (int s = 0; s < 3; s++) {
            int[][] dp = new int[N][3];
            for (int i = 0; i < 3; i++) {
                dp[0][i] = 1_000_000;
            }
            dp[0][s] = cost[0][s];
            for (int i = 1; i < N; i++) {
                dp[i][0] = cost[i][0]+Math.min(dp[i-1][1], dp[i-1][2]);
                dp[i][1] = cost[i][1]+Math.min(dp[i-1][0], dp[i-1][2]);
                dp[i][2] = cost[i][2]+Math.min(dp[i-1][0], dp[i-1][1]);
            }
            for (int e = 0; e < 3; e++) {
                if (s == e) continue;
                ans = Math.min(ans, dp[N-1][e]);
            }
        }
        System.out.print(ans);
    }

}