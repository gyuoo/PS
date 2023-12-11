import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String str;
        while ((str = br.readLine()) != null) {
            st = new StringTokenizer(str);
            int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken()), sum = n;
            while (n >= k) {
                sum += n/k;
                n = n/k + n%k;
            }
            sb.append(sum).append('\n');
        }
        System.out.println(sb);
    }
}