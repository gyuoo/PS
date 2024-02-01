import java.io.*;
import java.util.*;

public class Main {
	static int N, S, ans;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		ans = 0;
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)	arr[i] = Integer.parseInt(st.nextToken());
		choice(0, 0);
		if (S == 0) ans--;
		System.out.println(ans);
	}
	static void choice(int idx, int sum) {
		if (idx == N) {
			if (sum == S) ans++;
			return;
		}
		choice(idx+1, sum+arr[idx]);
		choice(idx+1, sum);
	}
}