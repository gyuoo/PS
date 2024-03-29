import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] arr = new long[N];
		arr[0] = Long.parseLong(st.nextToken());
		for (int i = 1; i < N; i++) arr[i] = arr[i-1]+Long.parseLong(st.nextToken());
		long ans = 0;
		for (int j = 2; j < N; j++) {
			int i = 0, start = 1, end = j-1;
			while (start <= end) {
				int mid = (start+end)/2;
				if (arr[mid-1] < arr[N-1]-arr[j-1] && arr[N-1]-arr[j-1] < arr[j-1]-arr[mid-1]) {
					start = mid+1;
					i = mid;
				} else end = mid-1;
			}
			ans += i;
		}
		System.out.print(ans);
	}
}