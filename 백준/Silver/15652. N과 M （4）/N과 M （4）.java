import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        choice(0, 1);
        System.out.print(sb);
    }
    static void choice(int idx, int num) {
        if (idx == M) {
            for (int i : arr) sb.append(i).append(' ');
            sb.append('\n');
            return;
        }
        for (int i = num; i <= N; i++) {
            arr[idx] = i;
            choice(idx+1, i);
        }
    }
}