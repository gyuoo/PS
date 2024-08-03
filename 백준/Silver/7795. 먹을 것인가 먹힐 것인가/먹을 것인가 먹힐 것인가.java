import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while (T-->0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
            int[] A = new int[N], B = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) B[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(A);
            Arrays.sort(B);
            int ans = 0;
            for (int i = 0; i < N; i++) {
                int start = 0, end = M-1;
                while (start <= end) {
                    int mid = (start+end)/2;
                    if (B[mid] < A[i]) start = mid+1;
                    else end = mid-1;
                }
                ans += start;
            }
            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }
}