import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()), min = 5;
        String ans = "";
        while (N-->0) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int level = Integer.parseInt(st.nextToken());
            if (level < min) {
                min = level;
                ans = name;
            }
        }
        System.out.println(ans);
    }
}