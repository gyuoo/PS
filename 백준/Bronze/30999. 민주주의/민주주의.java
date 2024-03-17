import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), ans = 0;
        while (N-->0) {
            char[] str = br.readLine().toCharArray();
            int cnt = 0;
            for (int i = 0; i < M; i++) {
                if (str[i] == 'O') cnt++;
            }
            if (cnt > M/2) ans++;
        }
        System.out.print(ans);
    }
}