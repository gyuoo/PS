import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-->0) {
            int s = Integer.parseInt(br.readLine()), n = Integer.parseInt(br.readLine());
            while (n-->0) {
                st = new StringTokenizer(br.readLine());
                s += Integer.parseInt(st.nextToken())*Integer.parseInt(st.nextToken());
            }
            sb.append(s).append('\n');
        }
        System.out.println(sb);
    }
}