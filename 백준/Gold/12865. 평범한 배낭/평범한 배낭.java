import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        int[] W = new int[N], V = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[K+1];
        for (int i = 0; i < N; i++) {
            int w = W[i], v = V[i];
            for (int j = K; j >= w; j--) {
                dp[j] = Math.max(dp[j], dp[j-w]+v);
            }
        }
        System.out.print(dp[K]);
    }
}