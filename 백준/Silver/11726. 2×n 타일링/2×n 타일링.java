import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()), dp[] = new int[n];
		dp[0] = 1;
		if (n >= 2) {
			dp[1] = 2;
			for (int i = 2; i < n; i++) {
				dp[i] = (dp[i-2]+dp[i-1])%10007;
			}
		}
		System.out.print(dp[n-1]);
	}
}