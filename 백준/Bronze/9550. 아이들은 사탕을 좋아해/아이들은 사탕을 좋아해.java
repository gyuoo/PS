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
            int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken()), sum = 0;
            st = new StringTokenizer(br.readLine());
            while (N-->0) sum += Integer.parseInt(st.nextToken()) / K;
            sb.append(sum).append('\n');
        }
        System.out.println(sb);
    }
}