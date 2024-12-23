import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int r, c;
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int w, h;
    static boolean[][] visited;
    static int[][] arr, dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}, {-1, 1}, {1, 1}, {-1, -1}, {1, -1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String str;
        while (!(str = br.readLine()).equals("0 0")) {
            st = new StringTokenizer(str);
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            arr = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            visited = new boolean[h][w];
            int ans = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (arr[i][j] == 1 && !visited[i][j]) {
                        ans++;
                        bfs(i, j);
                    }
                }
            }
            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }

    static void bfs(int r, int c) {
        visited[r][c] = true;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(r, c));
        while (!q.isEmpty()) {
            Node now = q.poll();
            for (int d = 0; d < 8; d++) {
                int nr = now.r + dir[d][0], nc = now.c + dir[d][1];
                if (!isInRange(nr, nc) || visited[nr][nc] || arr[nr][nc] == 0) continue;
                visited[nr][nc] = true;
                q.offer(new Node(nr, nc));
            }
        }
    }
    
    static boolean isInRange(int nr, int nc) {
        return 0 <= nr && nr < h && 0 <= nc && nc < w;
    }
}