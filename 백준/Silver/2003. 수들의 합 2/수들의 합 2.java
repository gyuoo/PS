import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        int start = 0, end = 0, ans = 0;
        long sum = 0;
        while (end <= N) {
            if (sum < M) {
                if (end == N) break;
                sum += arr[end++];
            }
            else {
                if (M == sum) ans++;
                sum -= arr[start++];
            }
        }
        System.out.print(ans);
    }
}