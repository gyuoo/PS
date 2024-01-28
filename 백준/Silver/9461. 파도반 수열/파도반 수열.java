import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        long[] arr = new long[100];
        arr[0] = arr[1] = arr[2] = 1;
        for (int i = 3; i < 100; i++) arr[i] = arr[i-3]+arr[i-2];
        while (T-->0) sb.append(arr[Integer.parseInt(br.readLine())-1]).append('\n');
        System.out.println(sb);
    }
}