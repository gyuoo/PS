import java.io.*;
import java.util.*;

public class Main {
	static int N, ans;
	static int[][] taste;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		taste = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			taste[i][0] = Integer.parseInt(st.nextToken());
			taste[i][1] = Integer.parseInt(st.nextToken());
		}
		ans = 1000000000;
		cook(0, 1, 0);
		System.out.println(ans);
	}
	static void cook(int idx, int mul, int sum) {
		if (idx == N) {
			if (sum > 0) ans = Math.min(ans, Math.abs(mul-sum));
			return;
		}
		cook(idx+1, mul, sum);
		cook(idx+1, mul*taste[idx][0], sum+taste[idx][1]);
	}
}