import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());
        long ans = 0;
        int max = arr[0], prev = arr[0];
        for (int i = 1; i < n; i++) {
            int now = arr[i];
            if (max < now) {
                ans += now-max;
                max = now;
            }
            else if (prev > now) ans += prev-now;
            prev = now;
        }
        System.out.print(ans);
    }
}