import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int r, c, k, d;
        Node (int r, int c, int k, int d) {
            this.r = r;
            this.c = c;
            this.k = k;
            this.d = d;
        }
    }
    static int K, W, H;
    static int[][] map, dir = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}},
        horse = {{-2, 1}, {-2, -1}, {-1, 2}, {-1, -2}, {1, 2}, {1, -2}, {2, 1}, {2, -1}};
    static boolean[][][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[H][W][K+1];
        System.out.println(bfs());
    }
    static int bfs() {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(0, 0, 0, 0));
        visited[0][0][0] = true;
        while (!q.isEmpty()) {
            Node now = q.poll();
            if (now.r == H-1 && now.c == W-1) return now.d;
            for (int d = 0; d < 4; d++) {
                int nr = now.r+dir[d][0], nc = now.c+dir[d][1];
                if (!IsInRange(nr, nc) || visited[nr][nc][now.k] || map[nr][nc] == 1) continue;
                visited[nr][nc][now.k] = true;
                q.offer(new Node(nr, nc, now.k, now.d+1));
            }
            if (now.k < K) {
                for (int d = 0; d < 8; d++) {
                    int nr = now.r+horse[d][0], nc = now.c+horse[d][1];
                    if (!IsInRange(nr, nc) || visited[nr][nc][now.k+1] || map[nr][nc] == 1) continue;
                    visited[nr][nc][now.k+1] = true;
                    q.offer(new Node(nr, nc, now.k+1, now.d+1));
                }
            }
        }
        return -1;
    }

    static boolean IsInRange(int nr, int nc) {
        return 0 <= nr && nr < H && 0 <= nc && nc < W;
    }
}