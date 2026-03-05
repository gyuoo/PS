import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static class Node {
        int r, c, cnt, ver;
        Node (int r, int c) {
            this.r = r;
            this.c = c;
        }
        Node (int r, int c, int cnt, int ver) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.ver = ver;
        }
    }
    static int N, ans;
    static Node start, end;
    static char[][] map;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static boolean[][][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N][2];
        int startCnt = 0, endCnt = 0, startR = -1, endR = -1;
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'B') {
                    startCnt++;
                    if (startCnt == 1) startR = i;
                    else if (startCnt == 2) start = new Node(i, j);
                }
                else if (map[i][j] == 'E') {
                    endCnt++;
                    if (endCnt == 1) endR = i ;
                    else if (endCnt == 2) end = new Node(i, j);
                }
            }
        }
        if (startR != start.r) start.ver = 1;
        else start.ver = 0;
        if (endR != end.r) end.ver = 1;
        else end.ver = 0;
        ans = 0;
        start.cnt = 0;
        bfs();
        System.out.print(ans);
    }

    static void bfs() {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(start);
        while (!q.isEmpty()) {
            Node now = q.poll();
            if (now.r == end.r && now.c == end.c && now.ver == end.ver) {
                ans = now.cnt;
                return;
            }
            if (canMove(now.r, now.c, now.ver)) {
                for (int d = 0; d < 4; d++) {
                    int nr = now.r+dir[d][0], nc = now.c+dir[d][1];
                    if (!isInRange(nr, nc) || visited[nr][nc][now.ver] || map[nr][nc] == '1') continue;
                    visited[nr][nc][now.ver] = true;
                    q.offer(new Node(nr, nc, now.cnt+1, now.ver));
                }
            }
            if (canTurn(now.r, now.c)) {
                if (visited[now.r][now.c][now.ver == 1 ? 0 : 1]) continue;
                visited[now.r][now.c][now.ver == 1 ? 0 : 1] = true;
                q.offer(new Node(now.r, now.c, now.cnt+1, now.ver == 1 ? 0 : 1));
            }
        }
    }

    static boolean canMove(int r, int c, int ver) {
        if (ver == 1) {
            for (int dr = -1; dr <= 1; dr++) {
                int nr = r+dr;
                if (!isInRange(nr, c) || map[nr][c] == '1') return false;
            }
        } else {
            for (int dc = -1; dc <= 1; dc++) {
                int nc = c+dc;
                if (!isInRange(r, nc) || map[r][nc] == '1') return false;
            }
        }
        return true;
    }

    static boolean canTurn(int r, int c) {
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                int nr = r+dr, nc = c+dc;
                if (!isInRange(nr, nc) || map[nr][nc] == '1') return false;
            }
        }
        return true;
    }

    static boolean isInRange(int nr, int nc) {
        return 0 <= nr && nr < N && 0 <= nc && nc < N;
    }
}