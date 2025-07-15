import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        for (int i = 0; i <= n; i++) parent[i] = i;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            if (num == 0) union(a, b);
            else sb.append(find(a) == find(b) ? "YES" : "NO").append('\n');
        }
        System.out.print(sb);
    }
    static int find(int n) {
        if (parent[n] != n) parent[n] = find(parent[n]);
        return parent[n];
    }
    static void union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa != pb) parent[pa] = pb;
    }
}