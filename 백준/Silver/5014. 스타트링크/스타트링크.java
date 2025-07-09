import java.io.*;
import java.util.*;

public class Main {
    static int F, S, G, U, D;
    static int[] cnt;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        visited = new boolean[F+1];
        cnt = new int[F+1];
        bfs();
    }
    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(S);
        visited[S] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == G) {
                System.out.print(cnt[now]);
                return;
            }
            int up = now+U, down = now-D;
            if (F >= up && !visited[up]) {
                visited[up] = true;
                q.offer(up);
                cnt[up] = cnt[now]+1;
            }
            if (1 <= down && !visited[down]) {
                visited[down] = true;
                q.offer(down);
                cnt[down] = cnt[now]+1;
            }
        }
        System.out.print("use the stairs");
    }
}