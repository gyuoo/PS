import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int to, cost;
        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static int n, m;
    static int[][] ans, dist;
    static List<Edge>[] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new ArrayList[n+1];
        ans = new int[n+1][n+1];
        dist = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            map[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), t = Integer.parseInt(st.nextToken());
            map[a].add(new Edge(b, t));
            map[b].add(new Edge(a, t));
        }
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        for (int i = 1; i <= n; i++) {
            findBestRoute(i);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) sb.append('-');
                else sb.append(ans[i][j]);
                sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    static void findBestRoute(int num) {
        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.offer(new Edge(num, 0));
        dist[num][num] = 0;
        while (!q.isEmpty()) {
            Edge now = q.poll();
            if (now.cost > dist[num][now.to]) continue;
            for (Edge next : map[now.to]) {
                int newCost = now.cost+next.cost;
                if (dist[num][next.to] > newCost) {
                    dist[num][next.to] = newCost;
                    if (now.to == num) {
                        ans[num][next.to] = next.to;
                    } else {
                        ans[num][next.to] = ans[num][now.to];
                    }
                    q.offer(new Edge(next.to, newCost));
                }
            }
        }
    }
}
