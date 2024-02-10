import java.io.*;
import java.util.*;

public class Main {
	static class Person {
		int num, depth;
		Person(int num, int depth) {
			this.num = num;
			this.depth = depth;
		}
	}
	static int sum;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> al;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		al = new ArrayList<>();
		for (int i = 0; i <= N; i++) al.add(new ArrayList<>());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
			al.get(A).add(B);
			al.get(B).add(A);
		}
		int min = Integer.MAX_VALUE, ans = 0;
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N+1];
			sum = 0;
			bfs(i, min);
			if (sum < min) {
				min = sum;
				ans = i;
			}
		}
		System.out.println(ans);
	}
	static void bfs(int num, int min) {
		visited[num] = true;
		Queue<Person> q = new LinkedList<>();
		q.offer(new Person(num, 0));
		while (!q.isEmpty()) {
			Person now = q.poll();
			for (int i : al.get(now.num)) {
				if (visited[i]) continue;
				sum += now.depth+1;
				if (sum >= min) return;
				visited[i] = true;
				q.offer(new Person(i, now.depth+1));
			}
		}
	}
}