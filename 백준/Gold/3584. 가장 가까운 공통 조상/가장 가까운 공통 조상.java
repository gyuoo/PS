import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while (T-->0) {
            int N = Integer.parseInt(br.readLine());
            int[] parentArr = new int[N+1];
            for (int i = 1; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
                parentArr[B] = A;
            }
            st = new StringTokenizer(br.readLine());
            int target1 = Integer.parseInt(st.nextToken()), target2 = Integer.parseInt(st.nextToken()), now = target1;
            ArrayList<Integer> list1 = new ArrayList<>();
            while (now != 0) {
                list1.add(now);
                now = parentArr[now];
            }
            now = target2;
            loop:
            while (now != 0) {
                for (int i : list1) {
                    if (now == i) {
                        sb.append(i).append('\n');
                        break loop;
                    }
                }
                now = parentArr[now];
            }
        }
        System.out.print(sb);
    }
}