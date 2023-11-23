import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while (T-->0) {
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[5];
            for (int i = 0; i < 5; i++) arr[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr);
            sb.append(arr[3]-arr[1] < 4 ? arr[1]+arr[2]+arr[3] : "KIN").append('\n');
        }
        System.out.println(sb);
    }
}