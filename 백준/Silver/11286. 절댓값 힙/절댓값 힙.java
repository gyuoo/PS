import java.io.*;
import java.util.*;

public class Main {
    static class Value implements Comparable<Value> {
        int val;
        Value (int val) {
            this.val = val;
        }

        @Override
        public int compareTo(Value o) {
            if (Math.abs(this.val) == Math.abs(o.val)) {
                return Integer.compare(this.val, o.val);
            }
            return Integer.compare(Math.abs(this.val), Math.abs(o.val));
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Value> pq = new PriorityQueue<>();
        while (N-->0) {
            int x = Integer.parseInt(br.readLine());
            if (x != 0) pq.offer(new Value(x));
            else {
                if (pq.isEmpty()) sb.append(0);
                else sb.append(pq.poll().val);
                sb.append('\n');
            }

        }
        System.out.print(sb);
    }
}