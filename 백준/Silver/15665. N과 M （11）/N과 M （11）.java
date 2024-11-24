import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr, arr2;
    static StringBuilder sb;
    static HashSet<String> hs;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        arr2 = new int[M];
        hs = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        choice(0);
        System.out.print(sb);
    }

    static void choice(int idx) {
        if (idx == M) {
            StringBuilder sb2 = new StringBuilder();
            for (int i : arr2) sb2.append(i).append(' ');
            if (!hs.contains(sb2.toString())) sb.append(sb2).append('\n');
            hs.add(sb2.toString());
            return;
        }
        for (int i = 0; i < N; i++) {
            arr2[idx] = arr[i];
            choice(idx+1);
        }
    }
}