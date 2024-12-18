import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N], dp = new int[1101];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;
            for (int j = 0; j <= arr[i]; j++) {
                dp[i+j] = Math.min(dp[i+j], dp[i]+1);
            }
        }
        System.out.print(dp[N-1] == Integer.MAX_VALUE ? -1 : dp[N-1]);
    }
}