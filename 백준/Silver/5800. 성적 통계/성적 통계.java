import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int K = Integer.parseInt(br.readLine());
		for (int t = 1; t <= K; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			for (int i = 0; i < N; i++)	arr[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(arr);
			int gap = 0;
			for (int i = 1; i < N; i++)	gap = Math.max(gap, Math.abs(arr[i]-arr[i-1]));
			sb.append("Class ").append(t).append('\n');
			sb.append("Max ").append(arr[N-1]).append(", Min ").append(arr[0]).append(", Largest gap ").append(gap).append('\n');
		}
		System.out.println(sb);
	}
}