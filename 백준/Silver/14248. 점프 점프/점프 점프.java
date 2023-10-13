import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] arr;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine())-1;
		visited = new boolean[n];
		bfs(start);
		int cnt = 0;
		for (boolean b : visited) {
			if (b) cnt++;
		}
		System.out.println(cnt);
	}
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visited[start] = true;
		while(!q.isEmpty()) {
			int now = q.poll();
			int left = now-arr[now], right = now+arr[now];
			if (0 <= left && left < n && !visited[left]) {
				visited[left] = true;
				q.offer(left);
			}
			if (0 <= right && right < n && !visited[right]) {
				visited[right] = true;
				q.offer(right);
			}
		}
	}
}