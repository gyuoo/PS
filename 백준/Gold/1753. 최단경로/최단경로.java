import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        int num, weight;
        Node (int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    static int[] dist;
    static ArrayList<Node>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int V = Integer.parseInt(st.nextToken()), E = Integer.parseInt(st.nextToken()), start = Integer.parseInt(br.readLine());
        graph = new ArrayList[V+1];
        for (int i = 0; i <= V; i++) graph[i] = new ArrayList<>();
        dist = new int[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            graph[Integer.parseInt(st.nextToken())].add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        dijkstra(start);
        for (int i = 1; i <= V; i++) {
            sb.append(dist[i] != Integer.MAX_VALUE ? dist[i] : "INF").append('\n');
        }
        System.out.print(sb);
    }
    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (now.weight > dist[now.num]) continue;
            for (Node next : graph[now.num]) {
                if (dist[next.num] > now.weight+next.weight) {
                    dist[next.num] = now.weight+next.weight;
                    pq.offer(new Node(next.num, dist[next.num]));
                }
            }
        }
    }
}