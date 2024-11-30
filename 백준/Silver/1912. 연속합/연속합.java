import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n], dp = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        int max = dp[0] = arr[0];
        for (int i = 1; i < n; i++) max = Math.max(max, dp[i] = Math.max(dp[i-1]+arr[i], arr[i]));
        System.out.print(max);
    }
}