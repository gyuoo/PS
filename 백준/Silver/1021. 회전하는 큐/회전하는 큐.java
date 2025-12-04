import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), ans = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) dq.offer(i);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken()), idx = 0;
            for (int j : dq) {
                if (j == target) break;
                idx++;
            }
            if (dq.size()/2 >= idx) {
                while (target != dq.peekFirst()) {
                    dq.offerLast(dq.pollFirst());
                    ans++;
                }
            }
            else {
                while (target != dq.peekFirst()) {
                    dq.offerFirst(dq.pollLast());
                    ans++;
                }
            }
            dq.pollFirst();
        }
        System.out.print(ans);
    }
}