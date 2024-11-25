import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static BigInteger K;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = BigInteger.valueOf(Long.parseLong(st.nextToken()));
        BigInteger max = combination(N+M, M);
        if (max.compareTo(K) < 0) System.out.println(-1);
        else {
            makeWord(N, M, K);
            System.out.println(sb);
        }
    }

    static BigInteger combination(int n, int r) {
        BigInteger result = BigInteger.ONE;
        for (int i = 0; i < r; i++) {
            result = result.multiply(BigInteger.valueOf(n-i)).divide(BigInteger.valueOf(i+1));
        }
        return result;
    }

    static void makeWord(int a, int z, BigInteger k) {
        if (a == 0) {
            for (int i = 0; i < z; i++) sb.append('z');
            return;
        }
        if (z == 0) {
            for (int i = 0; i < a; i++) sb.append('a');
            return;
        }
        BigInteger aCombi = combination(a+z-1, z);
        if (k.compareTo(aCombi) <= 0) {
            sb.append('a');
            makeWord(a-1, z, k);
        } else {
            sb.append('z');
            makeWord(a, z-1, k.subtract(aCombi));
        }
    }
}