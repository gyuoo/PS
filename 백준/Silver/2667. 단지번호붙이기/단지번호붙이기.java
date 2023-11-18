import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int N;
    static boolean[][] visited;
    static ArrayList<Integer> al;
    static int[][] arr, dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line[j]-'0';
            }
        }
        visited = new boolean[N][N];
        al = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    bfs(i, j);
                }
            }
        }
        Collections.sort(al);
        sb.append(al.size()).append('\n');
        for (int i : al) sb.append(i).append('\n');
        System.out.println(sb);
    }
    static void bfs(int r, int c) {
        int cnt = 1;
        Queue<Node> q = new LinkedList<>();
        visited[r][c] = true;
        q.offer(new Node(r, c));
        while(!q.isEmpty()) {
            Node now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = now.r+dir[i][0], nc = now.c+dir[i][1];
                if (isInRange(nr, nc) && !visited[nr][nc] && arr[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    cnt++;
                    q.offer(new Node(nr, nc));
                }
            }
        }
        al.add(cnt);
    }
    static boolean isInRange(int nr, int nc) {
        return 0 <= nr && nr < N && 0 <= nc && nc < N;
    }
}