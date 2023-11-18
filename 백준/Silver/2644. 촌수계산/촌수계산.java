import java.io.*;
import java.util.*;

public class Main {
    static int ans;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> al;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int targetA = Integer.parseInt(st.nextToken()), targetB = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        al = new ArrayList<>();
        for (int i = 0; i <= n; i++) al.add(new ArrayList<>());
        // 앞 번호 x : 부모, 뒷 번호 y : 자식
        while (m-->0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            al.get(x).add(y);
            al.get(y).add(x);
        }
        ans = -1;
        visited = new boolean[n+1];
        dfs(targetA, targetB, 0);
        System.out.println(ans);
    }
    static void dfs(int start, int end, int cnt) {
        visited[start] = true;
        if (start == end) {
            ans = cnt;
            return;
        }
        for (int i : al.get(start)) {
            if (!visited[i]) dfs(i, end, cnt+1);
        }
    }
}