import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = arr[i][j-1]+arr[i-1][j]-arr[i-1][j-1]+Integer.parseInt(st.nextToken());
			}
		}
		while (M-->0) {
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken()), c1 = Integer.parseInt(st.nextToken()), r2 = Integer.parseInt(st.nextToken()), c2 = Integer.parseInt(st.nextToken());
			sb.append(arr[r2][c2]-arr[r1-1][c2]-arr[r2][c1-1]+arr[r1-1][c1-1]).append('\n');
		}
		System.out.println(sb);
	}
}
