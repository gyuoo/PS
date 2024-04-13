import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), ans = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N], dp = new int[N];
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
        Arrays.fill(dp, 1);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }
        for (int i : dp) ans = Math.max(ans, i);
        System.out.print(ans);
    }
}