import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int sum1 = Integer.parseInt(st.nextToken())*3600 + Integer.parseInt(st.nextToken())*60 + Integer.parseInt(st.nextToken());
            int sum2 = Integer.parseInt(st.nextToken())*3600 + Integer.parseInt(st.nextToken())*60 + Integer.parseInt(st.nextToken());
            int[] arr = new int[3];
            int time = sum2-sum1;
            arr[0] = time/3600;
            time %= 3600;
            arr[1] = time/60;
            time %= 60;
            arr[2] = time;
            for (int n : arr) sb.append(n).append(' ');
            sb.append('\n');
        }
        System.out.println(sb);
    }
}