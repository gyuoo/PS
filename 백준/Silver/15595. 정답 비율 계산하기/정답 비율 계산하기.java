import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hm = new HashMap<>();
        int correct = 0, total = 0;
        while (N-->0) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            String name;
            if ((name = st.nextToken()).equals("megalusion")) continue;
            Integer tryCnt = hm.get(name);
            tryCnt = (tryCnt == null) ? 1 : tryCnt+1;
            if (tryCnt < 0) continue;
            hm.put(name, tryCnt);
            if (Integer.parseInt(st.nextToken()) == 4) {
                correct++;
                total += hm.get(name);
                hm.put(name, Integer.MIN_VALUE);
            }
        }
        System.out.println(total != 0 ? (double)correct/total*100 : 0);
    }
}