import java.io.*;
import java.util.*;

public class Main {
    static class Class implements Comparable<Class> {
        int num, start, end;
        Class(int num, int start, int end) {
            this.num = num;
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Class o) {
            return Integer.compare(this.start, o.start);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Class> pq = new PriorityQueue<>();
        PriorityQueue<Integer> endTime = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.offer(new Class(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        int ans = 0;
        while (!pq.isEmpty()) {
            Class c = pq.poll();
            if (!endTime.isEmpty() && c.start >= endTime.peek()) endTime.poll();
            endTime.offer(c.end);
            ans = Math.max(ans, endTime.size());
        }
        System.out.print(ans);
    }
}