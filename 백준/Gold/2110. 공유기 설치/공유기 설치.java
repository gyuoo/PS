import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int start = 1, end = arr[N-1]-arr[0]+1;
        while (start <= end) {
            int mid = (start+end)/2;
            if (C <= installed(mid)) start = mid+1;
            else end = mid-1;
        }
        System.out.print(end);
    }

    static int installed(int term) {
        int prev = arr[0], cnt = 1;
        for (int i = 1; i < N; i++) {
            if (term <= arr[i]-prev) {
                cnt++;
                prev = arr[i];
            }
        }
        return cnt;
    }
}