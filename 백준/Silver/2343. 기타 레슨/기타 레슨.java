import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), start = 0, end = 0;
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            start = Math.max(start, arr[i]);
            end += arr[i];
        }
        while (start <= end) {
            int sum = 0, cnt = 1, mid = (start+end)/2;
            for (int i = 0; i < N; i++) {
                if (mid < sum+arr[i]) {
                    sum = 0;
                    cnt++;
                }
                sum += arr[i];
            }
            if (M < cnt) start = mid+1;
            else end = mid-1;
        }
        System.out.print(start);
    }
}