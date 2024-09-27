import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), start = 0, end = 0;
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) end = Math.max(end, (arr[i] = Integer.parseInt(st.nextToken())));
		while (start <= end) {
			int mid = (start+end)/2;
			long sum = 0;
			for (int i : arr) {
				if (mid < i) sum += i-mid;
				if (M < sum) break;
			}
			if (sum < M) end = mid-1;
			else start = mid+1;
		}
		System.out.print(end);
	}
}