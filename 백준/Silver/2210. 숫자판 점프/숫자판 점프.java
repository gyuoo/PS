import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int r, c;
        String str;
        Node (int r, int c, String str) {
            this.r = r;
            this.c = c;
            this.str = str;
        }
    }
    static HashSet<String> hs;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        arr = new char[5][5];
        hs = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = st.nextToken().charAt(0);
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                bfs(i, j);
            }
        }
        System.out.print(hs.size());
    }
    static void bfs(int r, int c) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(r, c, arr[r][c]+""));
        while (!q.isEmpty()) {
            Node now = q.poll();
            if (now.str.length() == 6) {
                hs.add(now.str);
                continue;
            }
            for (int d = 0; d < 4; d++) {
                int nr = now.r+dir[d][0], nc = now.c+dir[d][1];
                if (!isInRange(nr, nc)) continue;
                q.offer(new Node(nr, nc, now.str+arr[nr][nc]));
            }
        }
    }
    static boolean isInRange(int nr, int nc) {
        return 0 <= nr && nr < 5 && 0 <= nc && nc < 5;
    }
}