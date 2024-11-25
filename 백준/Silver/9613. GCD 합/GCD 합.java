import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t--> 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            long ans = 0;
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
            for (int i = 0; i < n; i++) {
                for (int j = i+1; j < n; j++) {
                    ans += getGCD(arr[i], arr[j]);
                }
            }
            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }

    static int getGCD(int a, int b) {
        if (a%b == 0) return b;
        return getGCD(b, a%b);
    }
}