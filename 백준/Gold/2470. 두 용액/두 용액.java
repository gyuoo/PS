import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE, start = 0, end = N-1, ans1 = 0, ans2 = 0;
        while (start < end) {
            int sum = arr[start]+arr[end], diff = Math.abs(sum);
            if (diff < min) {
                min = diff;
                ans1 = arr[start];
                ans2 = arr[end];
            }
            if (sum < 0) start++;
            else if (sum > 0) end--;
            else break;
        }
        System.out.print(sb.append(ans1).append(' ').append(ans2));
    }
}