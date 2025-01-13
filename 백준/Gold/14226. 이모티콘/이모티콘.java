import java.io.*;
import java.util.*;

public class Main {
    static class Info {
        int screen, clipboard, time;
        Info (int screen, int clipboard, int time) {
            this.screen = screen;
            this.clipboard = clipboard;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = Integer.parseInt(br.readLine());
        Queue<Info> q = new LinkedList<>();
        q.offer(new Info(1, 0, 0));
        boolean[][] visited = new boolean[1001][1001];
        while (!q.isEmpty()) {
            Info now = q.poll();
            int ns = now.screen, nc = now.clipboard, nt = now.time;
            if (ns == S) {
                System.out.print(nt);
                break;
            }
            if (0 < ns) {
                q.offer(new Info(ns, ns, nt+1));
                visited[ns][ns] = true;
            }
            if (nc != 0 && ns+nc <= S && !visited[ns+nc][nc]) {
                q.offer(new Info(ns+nc, nc, nt+1));
                visited[ns+nc][nc] = true;
            }
            if (0 < ns && !visited[ns-1][nc]) {
                q.offer(new Info(ns-1, nc, nt+1));
                visited[ns-1][nc] = true;
            }
        }
    }
}