import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        long A = Long.parseLong(st.nextToken()), B = Long.parseLong(st.nextToken()), small = Math.min(A, B), big = Math.max(A, B);
        sb.append(big != small ? big-small-1 : 0).append('\n');
        for (long i = small+1; i < big; i++) {
            sb.append(i).append(' ');
        }
        System.out.print(sb);
    }
}