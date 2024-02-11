import java.io.*;
import java.util.*;

public class Main {
    static char[] K;
    static int intN, nK, ans;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken();
        intN = Integer.parseInt(N);
        nK = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        K = new char[nK];
        for (int i = 0; i < nK; i++) K[i] = st.nextToken().charAt(0);
        Arrays.sort(K);
        ans = 0;
        find(sb);
        System.out.println(ans);
    }
    static void find(StringBuilder sb) {
        if (0 < sb.length()) {
            int num = Integer.parseInt(sb.toString());
            if (num > intN) return;
            if (ans < num) ans = num;
        }
        for (int i = nK-1; i >= 0; i--) {
            sb.append(K[i]);
            find(sb);
            sb.setLength(sb.length()-1);
        }
    }
}