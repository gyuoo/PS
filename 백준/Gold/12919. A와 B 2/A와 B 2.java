import java.io.*;

public class Main {
    static int ans;
    static String S, T;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();
        ans = 0;
        tryAllWay(S);
        System.out.print(ans);
    }

    static void tryAllWay(String str) {
        if (ans == 1) return;
        if (str.length() == T.length()) {
            if (T.equals(str)) ans = 1;
            return;
        }
        String addA = str+'A', addB = new StringBuilder(str).append('B').reverse().toString();
        if (T.contains(addA) || T.contains(new StringBuilder(addA).reverse().toString())) {
            tryAllWay(addA);
        }
        if (T.contains(addB) || T.contains(new StringBuilder(addB).reverse().toString())) {
            tryAllWay(addB);
        }
    }
}