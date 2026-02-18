import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N], gap = new int[N-1];
        if (N <= K) {
            System.out.print(0);
            return;
        }
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        gap[0] = arr[1]-arr[0];
        for (int i = 1; i < N-1; i++) {
            gap[i] = arr[i+1]-arr[i];
        }
        Arrays.sort(gap);
        int ans = 0;
        for (int i = 0; i < N-K; i++) {
            ans += gap[i];
        }
        System.out.print(ans);
    }

}