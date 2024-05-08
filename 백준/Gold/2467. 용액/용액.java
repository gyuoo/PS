import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        int s = 0, e = N-1, a = 0, b = N-1, min = Math.abs(arr[0]+arr[N-1]);
        while (s < e) {
            int sum = arr[s]+arr[e];
            if (min > Math.abs(sum)) {
                min = Math.abs(sum);
                a = s;
                b = e;
            }
            if (sum < 0) s++;
            else if (sum > 0) e--;
            else break;
        }
        System.out.print(arr[a] + " " + arr[b]);
    }
}