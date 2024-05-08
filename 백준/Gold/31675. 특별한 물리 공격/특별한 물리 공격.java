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
		if (N == 2) ans = Math.max(arr[0], arr[1]);
		else if (N > 2) {
			dp[0] = arr[0];
			dp[1] = arr[1];
			dp[2] = Math.max(arr[0], arr[1])+arr[2];
			for (int i = 3; i < N; i++) {
                dp[i] = Math.max(dp[i-3]+arr[i-1], dp[i-2])+arr[i];
			}
			ans = Math.max(dp[N-3]+arr[N-1], dp[N-2]);
		}
		System.out.print(ans);
	}
}