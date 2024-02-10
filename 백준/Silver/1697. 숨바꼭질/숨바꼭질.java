import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
		int[] time = new int[100001];
		Queue<Integer> q = new LinkedList<>();
		q.offer(N);
		while (q.peek() != K) {
			int now = q.poll(), bw = now-1, fw = now+1, tp = now*2;
			if (0 <= bw && time[bw] == 0) {
				q.offer(bw);
				time[bw] = time[now]+1;
			}
			if (fw <= 100000 && time[fw] == 0) {
				q.offer(fw);
				time[fw] = time[now]+1;
			}
			if (tp <= 100000 && time[tp] == 0) {
				q.offer(tp);
				time[tp] = time[now]+1;
			}
		}
		System.out.println(time[q.peek()]);
	}
}