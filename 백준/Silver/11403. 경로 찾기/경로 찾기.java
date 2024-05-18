import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr, res;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        res = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            dfs(i);
            for (int j = 0; j < N; j++) {
                if (visited[j]) res[i][j] = 1;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(res[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
    static void dfs(int start) {
        for (int i = 0; i < N; i++) {
            if (visited[i] || arr[start][i] == 0) continue;
            visited[i] = true;
            dfs(i);
        }
    }
}