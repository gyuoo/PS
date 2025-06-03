import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine()), total = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[M];
        for (int i = 0; i < M; i++) total += arr[i] = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        double ans = 0;
        for (int i = 0; i < M; i++) {
            double temp = 1;
            for (int j = 0; j < K; j++) {
                temp *= (double)(arr[i]-j)/(total-j);
            }
            ans += temp;
        }
        System.out.print(ans);
    }
}