import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), M = Integer.parseInt(br.readLine()), left = 0, right = N-1, ans = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        while (left < right) {
            if (M < arr[left]+arr[right]) right--;
            else if (arr[left]+arr[right] < M) left++;
            else {
                left++;
                right--;
                ans++;
            }
        }
        System.out.print(ans);
    }
}