import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N], ans = new int[N];
        arr[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            ans[i] = ans[i-1];
            if (arr[i-1] > arr[i]) ans[i]++;
        }
        int Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1, y = Integer.parseInt(st.nextToken())-1;
            sb.append(ans[y]-ans[x]).append('\n');
        }
        System.out.print(sb);
    }
}