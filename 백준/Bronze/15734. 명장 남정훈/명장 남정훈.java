import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken()), R = Integer.parseInt(st.nextToken()), A = Integer.parseInt(st.nextToken());
        for (int i = A; i > 0; i--) {
            if (L > R) R++;
            else if (L < R) L++;
            else {
                System.out.println((L+i/2)*2);
                System.exit(0);
            }
        }
        System.out.println(Math.min(L, R)*2);
    }
}