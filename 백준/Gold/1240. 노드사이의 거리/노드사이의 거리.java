import java.io.*;
import java.util.*;

public class Main {
	static int len;
	static boolean[] visited;
	static ArrayList<ArrayList<Node>> al;
	static class Node {
		int b, len;
		public Node (int b, int len) {
			this.b = b;
			this.len = len;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		al = new ArrayList<>();
		for (int i = 0; i <= N; i++) al.add(new ArrayList<>());
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			al.get(a).add(new Node(b, len));
			al.get(b).add(new Node(a, len));
		}
		while (M-->0) {
			len = 0;
			visited = new boolean[N+1];
			st = new StringTokenizer(br.readLine());
			dfs(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
			sb.append(len).append('\n');
		}
		System.out.println(sb);
	}
	static void dfs(int a, int b, int sum) {
		visited[a] = true;
		if (a == b) {
			len = sum;
			return;
		}
		for (Node n : al.get(a)) {
			if (!visited[n.b]) dfs(n.b, b, sum+n.len);
		}
	}
}