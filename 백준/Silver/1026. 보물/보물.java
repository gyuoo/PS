import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), ans = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        Integer[] B = new Integer[N];
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) B[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());
        for (int i = 0; i < N; i++) ans += A[i]*B[i];
        System.out.print(ans);
    }
}