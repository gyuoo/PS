import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());
        int[] arr = new int[K];
        for (int i = 0; i < K; i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        long start = 1, end = arr[K-1];
        while (start <= end) {
            long mid = (start+end)/2, cnt = 0;
            for (int i : arr) cnt += i/mid;
            if (N <= cnt) start = mid+1;
            else end = mid-1;
        }
        System.out.println(end);
    }
}