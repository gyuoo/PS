import java.io.*;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int a, b, c;
        Edge (int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.c, o.c);
        }
    }
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()), M = Integer.parseInt(br.readLine());
        Edge[] edges = new Edge[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(edges);
        parent = new int[N+1];
        for (int i = 1; i <= N; i++) parent[i] = i;
        int cnt = 0, ans = 0;
        for (Edge e : edges) {
            if (union(e.a, e.b)) {
                ans += e.c;
                if (++cnt == N-1) break;
            }
        }
        System.out.print(ans);
    }
    static int find(int n) {
        if (parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }
    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return false;
        parent[b] = a;
        return true;
    }
}