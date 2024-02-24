import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken()), cnt = 1;
		int[] count = new int[d+1], dish = new int[N];
		count[c]++;
		for (int i = 0; i < N; i++) dish[i] = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			if (count[dish[i]]++ == 0) cnt++;
		}
		int ans = cnt;
		for (int i = k; i < N+k; i++) {
			if (count[dish[(i-k)%N]]-- == 1) cnt--;
			if (count[dish[i%N]]++ == 0) cnt++;
			ans = Math.max(ans, cnt);
		}
		System.out.println(ans);
	}
}