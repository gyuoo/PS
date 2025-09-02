import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(st.nextToken()), L = Integer.parseInt(st.nextToken());
        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        for (int i = 0; i < L; i++) {
            String str = br.readLine();
            lhs.remove(str);
            lhs.add(str);
        }
        int cnt = 0;
        for (String str : lhs) {
            sb.append(str).append('\n');
            if (++cnt == K) break;
        }
        System.out.print(sb);
    }
}