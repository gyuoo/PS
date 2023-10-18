import java.io.*;
import java.util.*;

public class Main {
	static int N, min;
	static String[] three, arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		while (T-->0) {
			N = Integer.parseInt(br.readLine());
			HashMap<String, Integer> hm = new HashMap<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				String mbti = st.nextToken();
				hm.put(mbti, hm.getOrDefault(mbti, 0)+1);
			}
			boolean flag = false;
			for (int i : hm.values()) {
				if (i >= 3) {
					sb.append(0);
					flag = true;
					break;
				}
			}
			if (!flag) {
				arr = new String[N];
				int idx = 0;
				for (String s : hm.keySet()) {
					while (hm.get(s) > 0) {
						hm.put(s, hm.get(s)-1);
						arr[idx++] = s;
					}
				}
				three = new String[3];
				min = Integer.MAX_VALUE;
				choice(0, 0);
				sb.append(min);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
	static void choice(int idx, int cnt) {
		if (cnt == 3) {
			int sum = 0;
			for (int i = 0; i < 4; i++) {
				if (three[0].charAt(i) != three[1].charAt(i)) sum++;
				if (three[1].charAt(i) != three[2].charAt(i)) sum++;
				if (three[2].charAt(i) != three[0].charAt(i)) sum++;
			}
			min = Math.min(min, sum);
			return;
		}
		if (idx == N) return;
		choice(idx+1, cnt);
		three[cnt] = arr[idx];
		choice(idx+1, cnt+1);
	}
}