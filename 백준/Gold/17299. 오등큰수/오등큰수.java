import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N], cnt = new int[1_000_001], ans = new int[N];
        for (int i = 0; i < N; i++) {
            cnt[A[i] = Integer.parseInt(st.nextToken())]++;
        }
        Arrays.fill(ans, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && cnt[A[stack.peek()]] < cnt[A[i]]) {
                ans[stack.pop()] = A[i];
            }
            stack.push(i);
        }
        for (int i = 0; i < N; i++) {
            sb.append(ans[i]).append(' ');
        }
        System.out.print(sb);
    }
}