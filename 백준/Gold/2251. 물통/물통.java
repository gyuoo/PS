import java.io.*;
import java.util.*;

public class Main {
    static int A, B, C;
    static HashSet<Integer> hs;
    static boolean[][][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        hs = new HashSet<>();
        visited = new boolean[A+1][B+1][C+1];
        bfs();
        ArrayList<Integer> al = new ArrayList<>(hs);
        Collections.sort(al);
        for (int i : al) {
            sb.append(i).append(' ');
        }
        System.out.print(sb);
    }
    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, C});
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int a = now[0], b = now[1], c = now[2];
            if (visited[a][b][c]) continue;
            visited[a][b][c] = true;
            if (a == 0) {
                hs.add(c);
            }
            if (a+b > B) q.offer(new int[]{a+b-B, B, c});
            else q.offer(new int[]{0, a+b, c});
            if (a+c > C) q.offer(new int[]{a+c-C, b, C});
            else q.offer(new int[]{0, b, a+c});
            if (b+a > A) q.offer(new int[]{A, b+a-A, c});
            else q.offer(new int[]{b+a, 0, c});
            if (b+c > C) q.offer(new int[]{a, b+c-C, C});
            else q.offer(new int[]{a, 0, b+c});
            if (c+a > A) q.offer(new int[]{A, b, c+a-A});
            else q.offer(new int[]{c+a, b, 0});
            if (c+b > B) q.offer(new int[]{a, B, c+b-B});
            else q.offer(new int[]{a, c+b, 0});
        }
    }
}