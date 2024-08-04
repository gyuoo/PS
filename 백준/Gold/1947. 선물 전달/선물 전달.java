import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[N+1];
		for (int i = 2; i <= N; i++) {
			dp[i] = (dp[i-1]*i+(i%2 == 0 ? 1 : -1))%1000000000;
		}
		System.out.print(dp[N]);
	}
}