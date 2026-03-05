import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int r, c;
        Node (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int R, C, ans;
    static Node start, end;
    static char[][] map;
    static boolean[][] swanVisited, waterVisited;
    static Queue<Node> waterQ, swanQ;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        waterQ = new ArrayDeque<>();
        waterVisited = new boolean[R][C];
        swanQ = new ArrayDeque<>();
        swanVisited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'L') {
                    if (start == null) start = new Node(i, j);
                    else end = new Node(i, j);
                    waterQ.offer(new Node(i, j));
                }
                else if (map[i][j] == '.') waterQ.offer(new Node(i, j));
            }
        }
        ans = 0;
        swanVisited[start.r][start.c] = true;
        swanQ.offer(start);
        while (!moveSwan()) {
            melt();
        }
        System.out.print(ans);
    }

    static boolean moveSwan() {
        Queue<Node> nextSwanQ = new ArrayDeque<>();
        while (!swanQ.isEmpty()) {
            Node now = swanQ.poll();
            if (now.r == end.r && now.c == end.c) {
                return true;
            }
            for (int d = 0; d < 4; d++) {
                int nr = now.r+dir[d][0], nc = now.c+dir[d][1];
                if (!isInRange(nr, nc) || swanVisited[nr][nc]) continue;
                swanVisited[nr][nc] = true;
                if (map[nr][nc] == 'X') nextSwanQ.offer(new Node(nr, nc));
                else swanQ.offer(new Node(nr, nc));
            }
        }
        swanQ = nextSwanQ;
        return false;
    }

    static void melt() {
        Queue<Node> nextWaterQ = new ArrayDeque<>();
        while (!waterQ.isEmpty()) {
            Node now = waterQ.poll();
            for (int d = 0; d < 4; d++) {
                int nr = now.r+dir[d][0], nc = now.c+dir[d][1];
                if (!isInRange(nr, nc) || waterVisited[nr][nc]) continue;
                waterVisited[nr][nc] = true;
                if (map[nr][nc] == 'X') {
                    nextWaterQ.offer(new Node(nr, nc));
                    map[nr][nc] = '.';
                }
                else waterQ.offer(new Node(nr, nc));
            }
        }
        waterQ = nextWaterQ;
        ans++;
    }

    static boolean isInRange(int nr, int nc) {
        return 0 <= nr && nr < R && 0 <= nc && nc < C;
    }
}