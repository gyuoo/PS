import java.io.*;
import java.util.*;

public class Main {
    static int ans, N, E;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> al;
    static class Node {
        int location, time;
        public Node(int location, int time) {
            this.location = location;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        al = new ArrayList<>();
        for (int i = 0; i <= N; i++) al.add(new ArrayList<>());
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            al.get(x).add(y);
            al.get(y).add(x);
        }
        visited = new boolean[N+1];
        ans = 0;
        bfs(S);
        System.out.println(ans);
    }
    static void bfs(int start) {
        Queue<Node> q = new LinkedList<>();
        visited[start] = true;
        q.offer(new Node(start, 0));
        while (!q.isEmpty()) {
            Node now = q.poll();
            int nl = now.location, nt = now.time;
            if (nl == E) {
                ans = nt;
                return;
            }
            visited[nl] = true;
            for (int i : al.get(nl)) {
                if (!visited[i]) q.offer(new Node(i, nt+1));
            }
            if (nl > 1 && !visited[nl-1]) {
                q.offer(new Node(nl-1, nt+1));
                visited[nl-1] = true;
            }
            if (nl < N && !visited[nl+1]) {
                q.offer(new Node(nl+1, nt+1));
                visited[nl+1] = true;
            }
        }
    }
}