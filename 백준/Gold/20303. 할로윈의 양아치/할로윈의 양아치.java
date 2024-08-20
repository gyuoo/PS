import java.io.*;
import java.util.*;

public class Main {
	static class Group {
		int kids, sum;
		Group(int kids, int sum) {
			this.kids = kids;
			this.sum = sum;
		}
	}
	static int K, kids, sum;
	static int[] candies;
	static boolean[] visited;
	static ArrayList<Integer>[] info;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		candies = new int[N];
		info = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			info[i] = new ArrayList<>();
			candies[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1, b = Integer.parseInt(st.nextToken())-1;
			info[a].add(b);
			info[b].add(a);
		}
		visited = new boolean[N];
		ArrayList<Group> groups = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			if (visited[i])	continue;
			visited[i] = true;
			kids = 1;
			sum = candies[i];
			bfs(i);
			if (K <= kids) continue;
			groups.add(new Group(kids, sum));
		}
		int[] dp = new int[K];
		for (Group g : groups) {
			for (int i = K-1; g.kids <= i; i--) {
				dp[i] = Math.max(dp[i], dp[i-g.kids]+g.sum);
			}
		}
		System.out.print(dp[K-1]);
	}
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int next : info[now]) {
				if (visited[next]) continue;
				visited[next] = true;
				kids++;
				sum += candies[next];
				q.offer(next);
			}
		}
	}
}