import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), ans = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N], dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = A[i] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+A[i]);
                }
            }
        }
        for (int i = 0; i < N; i++) ans = Math.max(ans, dp[i]);
        System.out.print(ans);
    }
}