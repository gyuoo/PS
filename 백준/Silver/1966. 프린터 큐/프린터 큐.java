import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Doc implements Comparable<Doc> {
        int idx, val;
        Doc (int idx, int val) {
            this.idx = idx;
            this.val = val;
        }

        @Override
        public int compareTo(Doc o) {
            return Integer.compare(this.val, o.val);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while (T-->0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            Queue<Doc> q = new ArrayDeque<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 0; i < N; i++) {
                int p = Integer.parseInt(st.nextToken());
                q.offer(new Doc(i, p));
                pq.offer(p);
            }
            int cnt = 0;
            while (!q.isEmpty()) {
                Doc d = q.peek();
                int val = pq.peek();
                while (d.val < val) {
                    q.offer(q.poll());
                    d = q.peek();
                }
                q.poll();
                pq.poll();
                cnt++;
                if (d.idx == M) break;
            }
            sb.append(cnt).append('\n');
        }
        System.out.print(sb);
    }
}
