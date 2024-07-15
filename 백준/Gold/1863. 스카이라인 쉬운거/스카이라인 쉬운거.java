import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()), ans = 0;
        int[] arr = new int[n+1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            Integer.parseInt(st.nextToken());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && stack.peek() > arr[i]) {
                stack.pop();
                ans++;
            }
            if (stack.isEmpty() || stack.peek() != arr[i]) stack.push(arr[i]);
        }
        System.out.print(ans);
    }
}