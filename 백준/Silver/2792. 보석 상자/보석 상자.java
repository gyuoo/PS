import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M  = Integer.parseInt(st.nextToken()), right = 0;
        int[] arr = new int[M];
        for (int i = 0; i < M; i++) right = Math.max(right, arr[i] = Integer.parseInt(br.readLine()));
        int left = 1, ans = right;
        while (left <= right) {
            int mid = (left+right)/2, sum = 0;
            for (int i = 0; i < M; i++) {
                sum += (arr[i]+mid-1)/mid;
                if (sum > N) break;
            }
            if (sum <= N) {
                ans = mid;
                right = mid-1;
            } else left = mid+1;
        }
        System.out.print(ans);
    }
}