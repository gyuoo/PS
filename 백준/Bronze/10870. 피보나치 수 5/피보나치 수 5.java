import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        if (n != 0) arr[1] = 1;
        for (int i = 2; i <= n; i++) arr[i] = arr[i-2]+arr[i-1];
        System.out.print(arr[n]);
    }
}