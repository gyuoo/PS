import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static boolean[][] visited;
	static int[][] maze, dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static class Node{
		int r, c;
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new int[N][M];
		for (int i = 0; i < N; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				maze[i][j] = c[j]-'0';
			}
		}
		visited = new boolean[N][M];
		bfs(0, 0);
		System.out.println(maze[N-1][M-1]);
	}
	static void bfs(int r, int c) {
		Queue<Node> q = new LinkedList<>();
		visited[r][c] = true;
		q.offer(new Node(r, c));
		while (!q.isEmpty()) {
			Node now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = now.r+dir[i][0], nc = now.c+dir[i][1];
				if (isInRange(nr, nc) && !visited[nr][nc] && maze[nr][nc] == 1) {
					visited[now.r][now.c] = true;
					maze[nr][nc] = maze[now.r][now.c]+1;
					q.offer(new Node(nr, nc));
				}
			}
		}
	}
	static boolean isInRange(int nr, int nc) {
		return 0 <= nr && nr < N && 0 <= nc && nc < M;
	}
}