import java.io.*;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge>{
        int u, v, w;
        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()), E = Integer.parseInt(st.nextToken());
        Edge[] edges = new Edge[E];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken()), w = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(u, v, w);
        }
        Arrays.sort(edges);
        parent = new int[V+1];
        for (int i = 0; i <= V; i++) parent[i] = i;
        int mstCost = 0, usedEdges = 0;
        for (Edge e : edges) {
            if (union(e.u, e.v)) {
                mstCost += e.w;
                if (++usedEdges == V-1) break;
            }
        }
        System.out.print(mstCost);
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