import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int J = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken()), ans = 0;
        while (N-->0) {
            String str = br.readLine();
            int sum = 0;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if ('A' <= c && c <= 'Z') sum += 4;
                else if (c == ' ') sum++;
                else sum += 2;
            }
            if (J >= sum) ans++;
        }
        System.out.println(ans);
    }
}