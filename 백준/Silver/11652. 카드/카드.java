import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), max = 0;
        long ans = 0;
        HashMap<Long, Integer> hm = new HashMap<>();
        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(br.readLine());
            hm.put(num, hm.getOrDefault(num, 0)+1);
        }
        for (long i : hm.keySet()) {
            if (max < hm.get(i)) {
                max = hm.get(i);
                ans = i;
            } else if (max == hm.get(i)) {
                ans = Math.min(ans, i);
            }
        }
        System.out.print(ans);
    }
}