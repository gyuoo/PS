import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str;
        while ((str = br.readLine()) != null) {
            int x = Integer.parseInt(str)*10000000, n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());
            Arrays.sort(arr);
            int start = 0, end = n-1;
            boolean flag = false;
            while (start < end) {
                int sum = arr[start]+arr[end];
                if (sum < x) start++;
                else if (sum > x) end--;
                else {
                    flag = true;
                    break;
                }
            }
            if (flag) sb.append("yes ").append(arr[start]).append(' ').append(arr[end]);
            else sb.append("danger");
            sb.append('\n');
        }
        System.out.print(sb);
    }
}