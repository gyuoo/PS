import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        while (N-->0) {
            st = new StringTokenizer(br.readLine());
            long p = Long.parseLong(st.nextToken()), t = Long.parseLong(st.nextToken());
            sb.append(p+t/4-t/7).append('\n');
        }
        System.out.println(sb);
    }
}