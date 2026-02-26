import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int idx, val;
        Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken()), L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Deque<Node> dq = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            while (!dq.isEmpty() && dq.peekFirst().idx <= i-L) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && dq.peekLast().val > num) {
                dq.pollLast();
            }
            dq.addLast(new Node(i, num));
            sb.append(dq.peekFirst().val).append(' ');
        }
        System.out.print(sb);
    }
}