import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] relations;
    static int[] cntArr, visited;
    static int N, visitStamp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        relations = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) relations[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
            relations[B].add(A);
        }
        visitStamp = 1;
        visited = new int[N+1];
        cntArr = new int[N+1];
        int max = 0;
        for (int i = 1; i <= N; i++) {
            bfs(i);
            if (cntArr[i] > max) max = cntArr[i];
        }
        for (int i = 1; i <= N; i++) {
            if (cntArr[i] == max) sb.append(i).append(' ');
        }
        System.out.print(sb);
    }
    static void bfs(int n) {
        visited[n] = visitStamp;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(n);
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : relations[now]) {
                if (visited[next] != visitStamp) {
                    visited[next] = visitStamp;
                    cntArr[n]++;
                    q.offer(next);
                }
            }
        }
        visitStamp++;
    }
}