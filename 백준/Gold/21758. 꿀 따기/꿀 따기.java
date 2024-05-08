import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N], sum = new int[N], sumRev = new int[N];
		sum[0] = arr[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) sum[i] = sum[i-1]+(arr[i] = Integer.parseInt(st.nextToken()));
		sumRev[N-1] = arr[N-1];
		for (int i = N-2; i >= 0; i--) sumRev[i] = sumRev[i+1]+arr[i];
		int max = 0;
		for (int i = 1; i < N-1; i++) {
			max = Math.max(max, sum[i]+sumRev[i]-arr[0]-arr[N-1]);
			max = Math.max(max, sumRev[0]-arr[N-1]-arr[i]+sumRev[0]-sumRev[i]);
			max = Math.max(max, sum[N-1]-arr[0]+(sum[N-1]-sum[i])-arr[i]);
		}
		System.out.print(max);
	}
}