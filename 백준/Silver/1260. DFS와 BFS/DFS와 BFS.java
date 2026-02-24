import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), V = Integer.parseInt(st.nextToken());
        graph = new List[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        for (int i = 0; i <= N; i++) {
            Collections.sort(graph[i]);
        }
        visited = new boolean[N+1];
        dfs(V);
        sb.append('\n');
        visited = new boolean[N+1];
        bfs(V);
        System.out.print(sb);
    }
    static void dfs(int V) {
        visited[V] = true;
        sb.append(V).append(' ');
        for (int i : graph[V]) {
            if (visited[i]) continue;
            dfs(i);
        }
    }
    static void bfs(int V) {
        visited[V] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(V);
        while (!q.isEmpty()) {
            int now = q.poll();
            sb.append(now).append(' ');
            for (int i : graph[now]) {
                if (visited[i]) continue;
                visited[i] = true;
                q.offer(i);
            }
        }
    }
}