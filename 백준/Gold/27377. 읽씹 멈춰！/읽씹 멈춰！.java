import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while (T-->0) {
            long n = Long.parseLong(br.readLine());
            st = new StringTokenizer(br.readLine());
            BigInteger s = new BigInteger(st.nextToken()), t = new BigInteger(st.nextToken()), ans = BigInteger.valueOf(0);
            while (n != 0) {
                if (n%2 == 1) {
                    ans = ans.add(s);
                    n--;
                }
                else {
                    BigInteger b = s.multiply(BigInteger.valueOf(n)).divide(BigInteger.valueOf(2));
                    ans = b.compareTo(t) < 0 ? ans.add(b) : ans.add(t);
                    n /= 2;
                }
            }
            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }
}