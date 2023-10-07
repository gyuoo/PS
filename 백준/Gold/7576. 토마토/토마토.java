import java.io.*;
import java.util.*;

public class Main {
	static int N, M, day;
	static int[][] arr, dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
	static class Node {
		int r, c;
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();
		boolean flag = true;
		loop:
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					flag = false;
					break loop;
				}
			}
		}
		System.out.println(flag ? (day == 0 ? 0 : day-1) : -1);
	}
	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 1)	q.offer(new Node(i, j));
			}
		}
		while (!q.isEmpty()) {
			Node now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = now.r+dir[i][0], nc = now.c+dir[i][1];
				if (0 <= nr && nr < N && 0 <= nc && nc < M && arr[nr][nc] == 0) {
					arr[nr][nc] = arr[now.r][now.c]+1;
					q.offer(new Node(nr, nc));
					day = arr[nr][nc];
				}
			}
		}
	}
}