import java.io.*;
import java.util.*;

public class Main {
    static int N, B;
    static int[] arr;
    static int[][][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
        dp = new int[N][B][2];
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < B-1; j++) {
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1]);
                dp[i][j][1] = Math.max(dp[i-1][j+1][0], dp[i-1][j+1][1]+arr[i]);
            }
        }
        System.out.print(Math.max(dp[N-1][0][0], dp[N-1][0][1]));
    }
}