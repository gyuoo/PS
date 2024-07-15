import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N], sortedA = new int[N];
        for (int i = 0; i < N; i++) sortedA[i] = A[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(sortedA);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i] == sortedA[j]) {
                    sb.append(j).append(' ');
                    sortedA[j] = -1;
                    break;
                }
            }
        }
        System.out.print(sb);
    }
}