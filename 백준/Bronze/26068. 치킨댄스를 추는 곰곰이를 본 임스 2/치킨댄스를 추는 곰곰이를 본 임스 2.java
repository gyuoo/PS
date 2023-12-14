import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()), ans = 0;
        while (N-->0) {
            st = new StringTokenizer(br.readLine(), "D-");
            if (Integer.parseInt(st.nextToken()) <= 90) ans++;
        }
        System.out.println(ans);
    }
}