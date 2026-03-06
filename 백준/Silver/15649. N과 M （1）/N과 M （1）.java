import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] ans;
	static boolean[] arr;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new boolean[N+1];
		ans = new int[M];
		choice(0);
		System.out.println(sb);
	}
	static void choice(int cnt) {
		if (cnt == M) {
			for (int i : ans) sb.append(i).append(' ');
			sb.append('\n');
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (arr[i]) continue;
			arr[i] = true;
			ans[cnt] = i;
			choice(cnt+1);
			arr[i] = false;
		}
	}
}