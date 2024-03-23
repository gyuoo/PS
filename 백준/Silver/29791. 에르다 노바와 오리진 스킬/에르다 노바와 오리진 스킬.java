import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[] arrA = new int[N], arrB = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arrA[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) arrB[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        int bind = arrA[0], cnt5 = 1, cnt6 = 1;
        for (int i = 1; i < N; i++) {
            if (bind+100 <= arrA[i]) {
                bind = arrA[i];
                cnt5++;
            }
        }
        bind = arrB[0];
        for (int i = 1; i < M; i++) {
            if (bind+360 <= arrB[i]) {
                bind = arrB[i];
                cnt6++;
            }
        }
        System.out.print(cnt5 + " " + cnt6);
    }
}