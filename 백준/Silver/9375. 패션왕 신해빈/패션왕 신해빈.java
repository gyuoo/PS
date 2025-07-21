import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        HashMap<String, Integer> hm;
        while (T-->0) {
            int n = Integer.parseInt(br.readLine()), ans = 1;;
            hm = new HashMap<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String key = st.nextToken();
                hm.put(key, hm.getOrDefault(key, 0)+1);
            }
            for (String key : hm.keySet()) {
                ans *= hm.get(key)+1;
            }
            sb.append(ans-1).append('\n');
        }
        System.out.print(sb);
    }
}