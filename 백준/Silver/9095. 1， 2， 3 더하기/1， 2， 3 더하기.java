import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, cnt;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-->0) {
            n = Integer.parseInt(br.readLine());
            arr = new int[]{1, 2, 3};
            cnt = 0;
            choice(0, 0);
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }
    static void choice(int num, int sum) {
        if (sum == n) {
            cnt++;
            return;
        }
        if (num == n) return;
        for (int i = 0; i < 3; i++) {
            choice(num+1, sum+arr[i]);
        }
    }
}