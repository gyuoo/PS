import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while (T-->0) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            boolean isAsc = true, isDesc = true;
            for (int i = 1; i < N; i++) {
                if (arr[i-1] < arr[i]) isDesc = false;
                else if (arr[i] < arr[i-1]) isAsc = false;
                if (!isDesc && !isAsc) break;
            }
            long ans = 0;
            if (isAsc) {
                for (int i = 0; i < N-1; i++) {
                    ans += arr[N-1]-arr[i];
                }
            } else if (!isDesc && !isAsc) {
                int max = 0;
                for (int i = N-1; 0 <= i; i--) {
                    if (max < arr[i]) {
                        max = arr[i];
                    } else {
                        ans += max-arr[i];
                    }
                }
            }
            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }
}