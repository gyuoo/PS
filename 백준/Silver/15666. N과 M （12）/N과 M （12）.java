import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static Integer[] arr;
	static int[] arr2;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		HashSet<Integer> hs = new HashSet<>();
		for (int i = 0; i < N; i++) hs.add(Integer.parseInt(st.nextToken()));
		Arrays.sort(arr = hs.toArray(new Integer[0]));
		arr2 = new int[M];
		choice(0, 0);
		System.out.println(sb);
	}
	static void choice(int idx, int start) {
		if (idx == M) {
			for (int i : arr2) sb.append(i).append(' ');
			sb.append('\n');
			return;
		}
		for (int i = start; i < arr.length; i++) {
			arr2[idx] = arr[i];
			choice(idx+1, i);
		}
	}
}
