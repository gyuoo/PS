import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
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
    static char[][] map;
    static boolean[][][] visited;
    static Node[] start, end;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N][2];
        start = new Node[3];
        end = new Node[3];
        for (int i = 0; i < 3; i++) {
            start[i] = new Node(-1, -1);
            end[i] = new Node(-1, -1);
        }
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'B') {
                    if (start[0].r == -1) start[0] = new Node(i, j);
                    else if (start[1].r == -1) start[1] = new Node(i, j);
                    else start[2] = new Node(i, j);
                }
                else if (map[i][j] == 'E') {
                    if (end[0].r == -1) end[0] = new Node(i, j);
                    else if (end[1].r == -1) end[1] = new Node(i, j);
                    else end[2] = new Node(i, j);
                }
            }
        }
        if (start[0].r != start[1].r) {
            start[1].ver = 1;
        }
        if (end[0].r != end[1].r) end[1].ver = 1;
        ans = 0;
        bfs();
        System.out.print(ans);
    }
    static void bfs() {
        Queue<Node[]> q = new LinkedList<>();
        start[1].cnt = 0;
        visited[start[1].r][start[1].c][start[1].ver] = true;
        q.offer(buildState(start[1].r, start[1].c, start[1].ver, 0));
        while (!q.isEmpty()) {
            Node[] now = q.poll();
            if (now[1].r == end[1].r && now[1].c == end[1].c && now[1].ver == end[1].ver) {
                ans = now[1].cnt;
                return;
            }
            for (int d = 0; d < 4; d++) {
                int nr = now[1].r+dir[d][0], nc = now[1].c+dir[d][1];
                if (!isInRange(nr, nc) || visited[nr][nc][now[1].ver] || !canMove(now, new Node(nr, nc))) continue;
                visited[nr][nc][now[1].ver] = true;
                q.offer(buildState(nr, nc, now[1].ver, now[1].cnt+1));
            }
            int nDir = now[1].ver == 1 ? 0 : 1;
            if (!visited[now[1].r][now[1].c][nDir] && canTurn3x3(now[1].r, now[1].c)) {
                visited[now[1].r][now[1].c][nDir] = true;
                q.offer(buildState(now[1].r, now[1].c, nDir, now[1].cnt+1));
            }
        }
    }

    static boolean canMove(Node[] train, Node destination) {
        if (train[1].ver == 1) {
            int dr = destination.r-1, dc = destination.c;
            for (int i = 0; i < 3; i++) {
                if (!isInRange(dr+i, dc) || map[dr+i][dc] == '1') return false;
            }
        } else {
            int dr = destination.r, dc = destination.c-1;
            for (int i = 0; i < 3; i++) {
                if (!isInRange(dr, dc+i) || map[dr][dc+i] == '1') return false;
            }
        }
        return true;
    }

    static Node[] buildState(int r, int c, int ver, int cnt) {
        Node[] s = new Node[3];
        s[1] = new Node(r, c, cnt, ver);
        if (ver == 1) {
            s[0] = new Node(r-1, c);
            s[2] = new Node(r+1, c);
        } else {
            s[0] = new Node(r, c-1);
            s[2] = new Node(r, c+1);
        }
        return s;
    }

    static boolean canTurn3x3(int r, int c) {
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