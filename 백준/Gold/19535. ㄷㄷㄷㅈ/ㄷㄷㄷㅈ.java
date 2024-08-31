import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] info;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		info = new ArrayList[N+1];
		long D = 0, G = 0;
		for (int i = 1; i <= N; i++) info[i] = new ArrayList<>();
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
			info[u].add(v);
			info[v].add(u);
		}
		boolean[] visited = new boolean[N+1];
		for (int now = 1; now <= N; now++) {
			long size = info[now].size();
			if (3 <= size) {
				G += (size*(size-1)*(size-2))/6;
			}
			visited[now] = true;
			for (int next : info[now]) {
				long size2 = info[next].size();
				if (visited[next]) continue;
				D += (size-1)*(size2-1);
			}
		}
		String ans;
		if (D > 3*G) ans = "D";
		else if (D < 3*G) ans = "G";
		else ans = "DUDUDUNGA";
		System.out.print(ans);
	}
}