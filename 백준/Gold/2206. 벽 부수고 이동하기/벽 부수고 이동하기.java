import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int r, c, w, dist;

        Node(int r, int c, int w, int dist) {
            this.r = r;
            this.c = c;
            this.w = w;
            this.dist = dist;
        }
    }

    static int N, M, ans;
    static char[][] map;
    static boolean[][][] visited;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        visited = new boolean[N][M][2];
        ans = Integer.MAX_VALUE;
        bfs();
        System.out.print(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    static void bfs() {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(0, 0, 0, 1));
        visited[0][0][0] = true;
        while (!q.isEmpty()) {
            Node now = q.poll();
            if (now.r == N-1 && now.c == M-1) {
                ans = Math.min(ans, now.dist);
            }
            for (int d = 0; d < 4; d++) {
                int nr = now.r+dir[d][0], nc = now.c+dir[d][1];
                if (!isInRange(nr, nc)) continue;
                if (map[nr][nc] == '0') {
                    if (visited[nr][nc][now.w]) continue;
                    visited[nr][nc][now.w] = true;
                    q.offer(new Node(nr, nc, now.w, now.dist+1));
                } else {
                    if (visited[nr][nc][1] || now.w == 1) continue;
                    visited[nr][nc][1] = true;
                    q.offer(new Node(nr, nc, 1, now.dist+1));
                }
            }
        }
    }

    static boolean isInRange(int nr, int nc) {
        return 0 <= nr && nr < N && 0 <= nc && nc < M;
    }
}