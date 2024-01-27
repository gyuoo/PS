import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int r, c, dist;
        public Node(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
    static int n, m;
    static boolean[][] visited;
    static int[][] arr, dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int sr = 0, sc = 0;
        arr = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                int A = Integer.parseInt(String.valueOf(line[j]));
                if (A == 2) {
                    sr = i;
                    sc = j;
                }
                arr[i][j] = A;
            }
        }
        int dist = bfs(sr, sc);
        if (dist != -1) sb.append("TAK").append('\n').append(dist);
        else sb.append("NIE");
        System.out.println(sb);
    }
    static int bfs(int r, int c) {
        visited[r][c] = true;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(r, c, 0));
        while (!q.isEmpty()) {
            Node now = q.poll();
            for (int d = 0; d < 4; d++) {
                int nr = now.r+dir[d][0], nc = now.c+dir[d][1];
                if (isInRange(nr, nc) && !visited[nr][nc] && arr[nr][nc] != 1) {
                    visited[nr][nc] = true;
                    if (arr[nr][nc] >= 3) return now.dist+1;
                    q.offer(new Node(nr, nc, now.dist+1));
                }
            }
        }
        return -1;
    }
    static boolean isInRange(int nr, int nc) {
        return 0 <= nr && nr < n && 0 <= nc && nc < m;
    }
}