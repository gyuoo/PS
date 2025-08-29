import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int ans = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while (i < N) {
            while (j < N && arr[j]-arr[i] < M) j++;
            if (j == N) break;
            ans = Math.min(ans, arr[j]-arr[i]);
            i++;
        }
        System.out.print(ans);
    }
}