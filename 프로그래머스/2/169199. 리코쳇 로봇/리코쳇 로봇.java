import java.util.*;

class Solution {
    static class Node {
        int r, c, cnt;
        Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    static int lenR, lenC;
    static Node start, end;
    static char[][] map;
    static boolean[][] visited;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int solution(String[] board) {
        lenR = board.length;
        lenC = board[0].length();
        map = new char[lenR][lenC];
        visited = new boolean[lenR][lenC];
        for (int i = 0; i < lenR; i++) {
            for (int j = 0; j < lenC; j++) {
                map[i][j] = board[i].charAt(j);
                if (map[i][j] == 'R') {
                    start = new Node(i, j, 0);
                } else if (map[i][j] == 'G') {
                    end = new Node(i, j, 0);
                }
            }
        }        
        return bfs();
    }
    
    static int bfs() {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(start.r, start.c, 0));
        visited[start.r][start.c] = true;
        while (!q.isEmpty()) {
            Node now = q.poll();
            if (now.r == end.r && now.c == end.c) {
                return now.cnt;
            }
            for (int d = 0; d < 4; d++) {
                Node moved = move(new Node(now.r, now.c, now.cnt), d);
                if (!isInRange(moved.r, moved.c) || visited[moved.r][moved.c]) continue;
                visited[moved.r][moved.c] = true;
                q.offer(moved);
            }
        }
        return -1;
    }
    
    static Node move(Node n, int d) {
        int nr = n.r, nc = n.c;
        while (true) {
            int tr = nr+dir[d][0], tc = nc+dir[d][1];
            if (!isInRange(tr, tc) || map[tr][tc] == 'D') {
                break;
            }
            nr = tr;
            nc = tc;
        }

        return new Node(nr, nc, n.cnt + 1);
    }
    
    static boolean isInRange(int nr, int nc) {
        return 0 <= nr && nr < lenR && 0 <= nc && nc < lenC;
    }
}