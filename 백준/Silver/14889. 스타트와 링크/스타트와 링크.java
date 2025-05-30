import java.io.*;
import java.util.*;

public class Main {
	static int N, min;
	static int[] sumR, sumC;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		sumR = new int[N];
		sumC = new int[N];
		int sum = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				sumR[i] += num;
				sumC[j] += num;
				sum += num;
			}
		}
		min = Integer.MAX_VALUE;
		choice(0, 0, sum);
		System.out.print(min);
	}
	static void choice(int idx, int cnt, int sum) {
		if (cnt == N/2) {
			if (sum == 0) {
				min = 0;
				return;
			}
			int absSum  = Math.abs(sum);
			if (absSum < min) min = absSum;
			return;
		}
		if (idx == N) return;
		choice(idx+1, cnt+1, sum-sumR[idx]-sumC[idx]);
		choice(idx+1, cnt, sum);
	}
}