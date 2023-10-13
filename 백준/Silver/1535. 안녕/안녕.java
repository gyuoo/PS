import java.io.*;
import java.util.*;

public class Main {
	static int N, ans;
	static int[][] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[2][N];
		for (int i = 0; i < 2; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = 0;
		choice(0, 0, 0);
		System.out.println(ans);
	}
	static void choice(int idx, int stamina, int pleasure) {
		if (stamina >= 100) {
			return;
		}
		if (idx == N) {
			ans = Math.max(ans, pleasure);
			return;
		}
		choice(idx+1, stamina+arr[0][idx], pleasure+arr[1][idx]);
		choice(idx+1, stamina, pleasure);
	}
}