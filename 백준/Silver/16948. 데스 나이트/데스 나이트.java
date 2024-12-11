import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int r, c, cnt;
        Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    static int N, r1, c1, r2, c2;
    static boolean[][] visited;
    static int[][] cnt, dir = {{-2, -1}, {-2, 1}, {0, -2}, {0, +2}, {2, -1}, {2, 1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());
        visited = new boolean[N][N];
        cnt = new int[N][N];
        for (int i = 0; i < N; i++) Arrays.fill(cnt[i], -1);
        cnt[r1][c1] = 0;
        bfs();
        System.out.print(cnt[r2][c2]);
    }

    static void bfs() {
        visited[r1][c1] = true;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(r1, c1, 0));
        while (!q.isEmpty()) {
            Node now = q.poll();
            if (now.r == r2 && now.c == c2) return;
            for (int d = 0; d < 6; d++) {
                int nr = now.r+dir[d][0], nc = now.c+dir[d][1];
                if (!isInRange(nr, nc) || visited[nr][nc]) continue;
                visited[nr][nc] = true;
                cnt[nr][nc] = now.cnt+1;
                q.offer(new Node(nr, nc, now.cnt+1));
            }
        }
    }
    static boolean isInRange(int nr, int nc) {
        return 0 <= nr && nr < N && 0 <= nc && nc < N;
    }
}