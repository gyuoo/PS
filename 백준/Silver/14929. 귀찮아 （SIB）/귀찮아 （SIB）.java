import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n], sum = new int[n];
        arr[0] = sum[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < n; i++) sum[i] = sum[i-1]+(arr[i] = Integer.parseInt(st.nextToken()));
        long ans = 0;
        for(int i = 0; i < n-1; i++) ans += (long)arr[i]*(sum[n-1]-sum[i]);
        System.out.print(ans);
    }
}