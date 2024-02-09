import java.io.*;
import java.util.*;

public class Main {
	static int[] prev, next;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		prev = new int[1000001];
		next = new int[1000001];
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		prev[arr[0]] = arr[N-1];
		next[arr[0]] = arr[1];
		for (int i = 1; i < N; i++) {
			prev[arr[i]] = arr[i-1];
			next[arr[i]] = arr[(i+1)%N];
		}
		while (M-->0) {
			st = new StringTokenizer(br.readLine());
			char[] command = st.nextToken().toCharArray();
			int num = Integer.parseInt(st.nextToken());
			if (command[0] == 'B') B(num, command[1] == 'N' ? true : false, Integer.parseInt(st.nextToken()));
			else C(num, command[1] == 'N' ? true : false);
			sb.append('\n');
		}
		System.out.println(sb);
	}
	
	static void B(int num, boolean flag, int newNum) {
		int target = flag ? next[num] : prev[num];
		sb.append(target);
		if (flag) {
			prev[newNum] = num;
			next[newNum] = target;
			prev[target] = newNum;
			next[num] = newNum;
		} else {
			next[newNum] = num;
			prev[newNum] = target;
			next[target] = newNum;
			prev[num] = newNum;
		}
	}
	
	static void C(int num, boolean flag) {
		int target = flag ? next[num] : prev[num];
		sb.append(target);
		if (flag) {
			prev[next[target]] = num;
			next[num] = next[target];
		} else {
			next[prev[target]] = num;
			prev[num] = prev[target];
		}
		next[target] = prev[target] = 0;
	}
}