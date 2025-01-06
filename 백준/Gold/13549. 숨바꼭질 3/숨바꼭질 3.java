import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int time, loc;
        Node (int time, int loc) {
            this.time = time;
            this.loc = loc;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[100001];
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, N));
        int ans = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Node now = q.poll();
            int X = now.loc, T = now.time, bw = X-1, fw = X+1, tp = 2*X;
            visited[X] = true;
            if (X == K) ans = Math.min(ans, T);
            if (0 <= bw && !visited[bw]) q.offer(new Node(T+1, bw));
            if (fw <= 100000 && !visited[fw]) q.offer(new Node(T+1, fw));
            if (tp <= 100000 && !visited[tp]) q.offer(new Node(T, tp));
        }
        System.out.print(ans);
    }
}