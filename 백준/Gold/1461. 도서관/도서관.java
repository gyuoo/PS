import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> positive = new ArrayList<>(), negative = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (0 < n) positive.add(n);
            else negative.add(-n);
        }
        Collections.sort(positive, Collections.reverseOrder());
        Collections.sort(negative, Collections.reverseOrder());
        int ans = 0, maxDist = 0;
        if (!positive.isEmpty()) maxDist = Math.max(maxDist, positive.get(0));
        if (!negative.isEmpty()) maxDist = Math.max(maxDist, negative.get(0));
        for (int i = 0; i < positive.size(); i += M) ans += positive.get(i)*2;
        for (int i = 0; i < negative.size(); i += M) ans += negative.get(i)*2;
        ans -= maxDist;
        System.out.print(ans);
    }
}