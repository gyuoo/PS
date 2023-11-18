import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int r, c, h;
        public Node(int r, int c, int h) {
            this.r = r;
            this.c = c;
            this.h = h;
        }
    }
    static int N, M, H, tomato, ans;
    static Queue<Node> q;
    static boolean[][][] visited;
    static int[][][] arr;
    static int[][] dir = {{-1, 0, 0}, {0, 1, 0}, {1, 0, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[N][M][H];
        tomato = 0;
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if (arr[i][j][k] != -1) tomato++;
                }
            }
        }
        if (isAllRed(arr)) {
            System.out.println(0);
            System.exit(0);
        }
        q = new LinkedList<>();
        visited = new boolean[N][M][H];
        ans = 0;
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j][k] == 1 && !visited[i][j][k]) {
                        visited[i][j][k] = true;
                        q.offer(new Node(i, j, k));
                        tomato--;
                    }
                }
            }
        }
        bfs();
        System.out.println(tomato == 0 ? ans-1 : -1);
    }
    static void bfs() {
        while (!q.isEmpty()) {
            Node now = q.poll();
            for (int i = 0; i < 6; i++) {
                int nr = now.r+dir[i][0], nc = now.c+dir[i][1], nh = now.h+dir[i][2];
                if (isInRange(nr, nc, nh) && !visited[nr][nc][nh] && arr[nr][nc][nh] == 0) {
                    arr[nr][nc][nh] = arr[now.r][now.c][now.h]+1;
                    ans = Math.max(ans, arr[nr][nc][nh]);
                    q.offer(new Node(nr, nc, nh));
                    tomato--;
                }
            }
        }
    }
    static boolean isInRange(int nr, int nc, int nh) {
        return 0 <= nr && nr < N && 0 <= nc && nc < M && 0 <= nh && nh < H;
    }
    static boolean isAllRed(int[][][] arr) {
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j][k] == 0) return false;
                }
            }
        }
        return true;
    }
}