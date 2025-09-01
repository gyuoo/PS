import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), T = Integer.parseInt(st.nextToken());
        int[] K = new int[N], S = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            K[i] = Integer.parseInt(st.nextToken());
            S[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[T+1];
        for (int i = 0; i < N; i++) {
            int k = K[i], s = S[i];
            for (int j = T; k <= j; j--) {
                dp[j] = Math.max(dp[j], dp[j-k]+s);
            }
        }
        System.out.print(dp[T]);
    }
}