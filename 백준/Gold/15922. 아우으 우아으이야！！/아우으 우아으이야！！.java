import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken()), end = Integer.parseInt(st.nextToken()), ans = end-start;
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int ns = Integer.parseInt(st.nextToken()), ne = Integer.parseInt(st.nextToken());
			if (ns <= end && end < ne) {
				ans += ne-end;
				end = ne;
			} else if (end < ns) {
				ans += ne-ns;
				end = ne;
			}
		}
		System.out.print(ans);
	}
}