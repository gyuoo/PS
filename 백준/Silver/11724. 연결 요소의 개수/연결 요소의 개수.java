import java.io.*;
import java.util.*;

public class Main {
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> al;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		al = new ArrayList<>();
		visited = new boolean[N+1];
		for (int i = 0; i <= N; i++) al.add(new ArrayList<>());
		while (M-->0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			al.get(u).add(v);
			al.get(v).add(u);
		}
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				bfs(i);
				ans++;
			}
		}
		System.out.println(ans);
	}
	static void bfs(int n) {
		visited[n] = true;
		Queue<Integer> q = new LinkedList<>();
		q.offer(n);
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int i : al.get(now)) {
				if (!visited[i]) {
					visited[i] = true;
					q.offer(i);
				}
			}
		}
	}
}