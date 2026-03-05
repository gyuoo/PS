import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int r, c, d;
        Node (int r, int c) {
            this.r = r;
            this.c = c;
        }
        Node (int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
    static int R, C, ans;
    static Node start;
    static Queue<Node> fireQ, moveQ;
    static boolean[][] visited, fireVisited;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static char[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        fireVisited = new boolean[R][C];
        moveQ = new ArrayDeque<>();
        fireQ = new ArrayDeque<>();
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'J') moveQ.offer(start = new Node(i, j, 0));
                else if (map[i][j] == 'F') {
                    fireQ.offer(new Node(i, j));
                    fireVisited[i][j] = true;
                }
            }
        }
        ans = -1;
        visited[start.r][start.c] = true;
        while (true) {
            fire();
            if (!move()) break;
            if (ans != -1) break;
        }
        System.out.print(ans == -1 ? "IMPOSSIBLE" : ans);
    }

    static void fire() {
        Queue<Node> nextFireQ = new ArrayDeque<>();
        while (!fireQ.isEmpty()) {
            Node now = fireQ.poll();
            for (int d = 0; d < 4; d++) {
                int nr = now.r+dir[d][0], nc = now.c+dir[d][1];
                if (!isInRange(nr, nc) || fireVisited[nr][nc] || map[nr][nc] == '#') continue;
                fireVisited[nr][nc] = true;
                nextFireQ.offer(new Node(nr, nc));
                map[nr][nc] = 'F';
            }
        }
        fireQ = nextFireQ;
    }

    static boolean move() {
        Queue<Node> nextMoveQ = new ArrayDeque<>();
        boolean flag = false;
        while (!moveQ.isEmpty()) {
            Node now = moveQ.poll();
            for (int d = 0; d < 4; d++) {
                int nr = now.r+dir[d][0], nc = now.c+dir[d][1];
                if (!isInRange(nr, nc)) {
                    ans = now.d+1;
                    return true;
                }
                if (visited[nr][nc] || map[nr][nc] != '.') continue;
                visited[nr][nc] = true;
                nextMoveQ.offer(new Node(nr, nc, now.d+1));
                flag = true;
            }
        }
        moveQ = nextMoveQ;
        return flag;
    }

    static boolean isInRange(int nr, int nc) {
        return 0 <= nr && nr < R && 0 <= nc && nc < C;
    }
}