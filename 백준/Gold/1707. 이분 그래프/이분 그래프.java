import java.io.*;
import java.util.*;

public class Main {
    static boolean valid;
    static ArrayList<Integer>[] graph;
    static int[] teamNum;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int K = Integer.parseInt(br.readLine());
        while (K-->0) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken()), E = Integer.parseInt(st.nextToken());
            graph = new ArrayList[V];
            for (int i = 0; i < V; i++) graph[i] = new ArrayList<>();
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken())-1, v = Integer.parseInt(st.nextToken())-1;
                graph[u].add(v);
                graph[v].add(u);
            }
            teamNum = new int[V];
            valid = true;
            for (int i = 0; i < V; i++) {
                if (teamNum[i] == 0) {
                    teamNum[i] = 1;
                    bfs(i);
                }
                if (!valid) break;
            }
            sb.append(valid ? "YES" : "NO").append('\n');
        }
        System.out.print(sb);
    }
    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph[now]) {
                if (teamNum[now] == teamNum[next]) {
                    valid = false;
                    return;
                }
                if (teamNum[next] == 0) {
                    teamNum[next] = teamNum[now]*(-1);
                    q.offer(next);
                }
            }
        }
    }
}