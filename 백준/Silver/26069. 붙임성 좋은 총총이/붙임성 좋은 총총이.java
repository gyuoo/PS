import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        HashSet<String> hs = new HashSet<>();
        hs.add("ChongChong");
        int N = Integer.parseInt(br.readLine());
        while (N-->0) {
            st = new StringTokenizer(br.readLine());
            String A = st.nextToken(), B = st.nextToken();
            if (hs.contains(A) || hs.contains(B)) {
                hs.add(A);
                hs.add(B);
            }
        }
        System.out.print(hs.size());
    }
}