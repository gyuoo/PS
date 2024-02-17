import java.io.*;
import java.util.*;

public class Main {
	static int ans;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> al;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		al = new ArrayList<>();
		for (int i = 0; i <= N; i++) al.add(new ArrayList<>());
		int[] parents = new int[N];
		Arrays.fill(parents, -1);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = st.nextToken().charAt(0)-'A', B = st.nextToken().charAt(0)-'A';
			al.get(A).add(B);
			parents[B] = A;
		}
		st = new StringTokenizer(br.readLine());
		ArrayList<Integer> rootList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			if (parents[i] == -1) rootList.add(i);
		}
		visited = new boolean[N];
		int K = Integer.parseInt(st.nextToken());
		for (int i = 0; i < K; i++) visited[st.nextToken().charAt(0)-'A'] = true;
		ans = 0;
		for (int i : rootList) {
			if (visited[i]) continue;
			visited[i] = true;
			find(i);
		}
		System.out.println(ans);
	}
	static void find(int idx) {
		for (int i : al.get(idx)) {
			if (visited[i]) continue;
			visited[i] = true;
			ans++;
			find(i);
		}
	}
}