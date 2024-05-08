import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		long ans = 0, dp[] = new long[N];
		if (N == 2) ans = Math.min(arr[0], arr[1]);
		else if (N > 2) {
			dp[0] = arr[0];
			dp[1] = arr[1];
			for (int i = 2; i < N; i++) {
				dp[i] = Math.min(dp[i-2], dp[i-1])+arr[i];
			}
			ans = Math.min(dp[N-2], dp[N-1]);
		}
		System.out.print(ans);
	}
}