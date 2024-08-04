import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int odd = Integer.MAX_VALUE, even = Integer.MAX_VALUE;
        for (int i = 0; i < N-1; i++) {
            int diff1 = arr[i+1]-arr[i], diff2 = Integer.MAX_VALUE;
            if (i < N-2) diff2 = arr[i+2]-arr[i];
            if (diff1%2 == 0 && diff1 < even) even = diff1;
            else if (diff2%2 == 0 && diff2 < even) even = diff2;
            if (diff1%2 == 1 && diff1 < odd) odd = diff1;
            else if (diff2%2 == 1 && diff2 < odd) odd = diff2;
        }
        sb.append(even != Integer.MAX_VALUE ? even : -1).append(' ').append(odd != Integer.MAX_VALUE ? odd : -1);
        System.out.print(sb);
    }
}