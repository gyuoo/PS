import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int cnt = 0;
        while (true) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i]%2 == 1) {
                    arr[i]--;
                    cnt++;
                }
                sum += arr[i];
            }
            if (sum == 0) break;
            for (int i = 0; i < N; i++) {
                arr[i] /= 2;
            }
            cnt++;
        }
        System.out.print(cnt);
    }
}