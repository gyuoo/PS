import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node implements Comparable<Node> {
        int to, weight;
        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static int V, E, K;
    static List<Node>[] graph;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        graph = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken()), w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
        }
        dist = new int[V+1];
        Arrays.fill(dist, INF);
        dijkstra(K);
        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) sb.append("INF");
            else sb.append(dist[i]);
            sb.append('\n');
        }
        System.out.print(sb);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (dist[now.to] < now.weight) continue;
            for (Node next : graph[now.to]) {
                if (dist[next.to] > dist[now.to]+next.weight) {
                    dist[next.to] = dist[now.to]+next.weight;
                    pq.offer(new Node(next.to, dist[next.to]));
                }
            }
        }
    }
}