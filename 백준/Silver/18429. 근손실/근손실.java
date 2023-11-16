import java.io.*;
import java.util.*;

public class Main {
    static int N, K, ans;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[N];
        ans = 0;
        choice(0, 500);
        System.out.println(ans);
    }
    static void choice(int num, int sum) {
        if (num == N) {
            ans++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i] && sum+arr[i]-K >= 500) {
                visited[i] = true;
                choice(num+1, sum+arr[i]-K);
                visited[i] = false;
            }
        }
    }
}