import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] A = st.nextToken().toCharArray(), B = st.nextToken().toCharArray();
        int lenA = A.length, lenB = B.length;
        int ans = Integer.MAX_VALUE;
        for (int d = 0; d <= lenB-lenA; d++) {
            int diff = 0;
            for (int i = 0; i < lenA; i++) {
                if (A[i] != B[i+d]) diff++;
            }
            ans = Math.min(ans, diff);
        }
        System.out.print(ans);
    }
}
