import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, mark;
    static List<Integer>[] map;
    static int[] cnts, visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new List[N+1];
        cnts = new int[N+1];
        for (int i = 0; i <= N; i++) {
            map[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
            map[B].add(A);
        }
        visited = new int[N+1];
        mark = 0;
        for (int i = 1; i <= N; i++) {
            cnts[i] = bfs(i);
        }
        int max = 0;
        for (int i : cnts) {
            max = Math.max(max, i);
        }
        List<Integer> answers = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (cnts[i] == max) answers.add(i);
        }
        for (int i : answers) {
            sb.append(i).append(' ');
        }
        System.out.print(sb);
    }
    static int bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        mark++;
        visited[start] = mark;
        int cnt = 1;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i : map[now]) {
                if (visited[i] == mark) continue;
                visited[i] = mark;
                q.offer(i);
                cnt++;
            }
        }
        return cnt;
    }

}