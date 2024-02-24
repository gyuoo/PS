import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int r, c;
		Node (int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static char[][] arr;
	static ArrayList<Node> puyos;
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new char[12][6];
		for (int i = 0; i < 12; i++) arr[i] = br.readLine().toCharArray();
		int combo = 0;
		for (int t = 0; t < 18; t++) {
			moveDown();
			boolean flag = false;
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (arr[i][j] != '.' && canRemove(i, j, arr[i][j])) {
						remove(puyos);
						flag = true;
					}
				}
			}
			if (flag) combo++;
			else break;
		}
		System.out.println(combo);
	}
	
	static boolean canRemove(int r, int c, char puyo) {
		boolean[][] visit = new boolean[12][6];
		visit[r][c] = true;
		Queue<Node> q = new LinkedList<>();
		puyos = new ArrayList<>();
		q.offer(new Node(r, c));
		puyos.add(new Node(r, c));
		while (!q.isEmpty()) {
			Node now = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = now.r+dir[d][0], nc = now.c+dir[d][1];
				if (nr < 0 || 12 <= nr || nc < 0 || 6 <= nc || visit[nr][nc] || arr[nr][nc] != puyo) continue;
				visit[nr][nc] = true;
				q.offer(new Node(nr, nc));
				puyos.add(new Node(nr, nc));
			}
		}
		return puyos.size() >= 4;
	}
	
	static void remove(ArrayList<Node> puyos) {
		for (Node puyo : puyos) arr[puyo.r][puyo.c] = '.'; 
	}
	
	static void moveDown() {
		char[][] temp = new char[12][6];
		for (char[] cArr : temp) Arrays.fill(cArr, '.');
		for (int i = 0; i < 6; i++) {
			int idxR = 11;
			for (int j = 11; j >= 0; j--) {
				if (arr[j][i] != '.') {
					temp[idxR--][i] = arr[j][i];
				}
			}
		}
		arr = temp;
	}
}