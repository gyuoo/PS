import java.io.*;
import java.util.*;

public class Main {
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> al = new ArrayList<>();
	static Queue<Integer> q = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		for (int i = 0; i <= N; i++) al.add(new ArrayList<>());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			al.get(a).add(b);
			al.get(b).add(a);
		}
		for (int i = 1; i <= N; i++) Collections.sort(al.get(i));
		visited = new boolean[N+1];
		dfs(V);
		sb.append('\n');
		visited = new boolean[N+1];
		bfs(V);
		System.out.println(sb);
	}
	static void dfs(int V) {
		visited[V] = true;
		sb.append(V).append(' ');
		for (int i : al.get(V)) {
			if (!visited[i]) dfs(i);
		}
	}
	static void bfs(int V) {
		visited[V] = true;
		q.offer(V);
		while (!q.isEmpty()) {
			int num = q.poll();
			sb.append(num).append(' ');
			for (int i : al.get(num)) {
				if (!visited[i]) {
					visited[i] = true;
					q.offer(i);
				}
			}
		}
	}
}