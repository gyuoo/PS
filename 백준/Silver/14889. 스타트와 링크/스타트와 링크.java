import java.io.*;
import java.util.*;

public class Main {
	static int N, min;
	static int[][] arr;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		min = 100;
		visited = new boolean[N];
		combi(0, 0);
		System.out.println(min);
	}
	static void combi(int idx, int cnt) {
		if (cnt == N/2) {
			int sum1 = 0, sum2 = 0;
			for (int i = 0; i < N-1; i++) {
				for (int j = i+1; j < N; j++) {
					if (visited[i] && visited[j]) sum1 += arr[i][j] + arr[j][i];
					else if (!visited[i] && !visited[j]) sum2 += arr[i][j] + arr[j][i];
				}
			}
			min = Math.min(min, Math.abs(sum1-sum2));
			return;
		}
		for (int i = idx; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				combi(i+1, cnt+1);
				visited[i] = false;
			}
		}
	}
}