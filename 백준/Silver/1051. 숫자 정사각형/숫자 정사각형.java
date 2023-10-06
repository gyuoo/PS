import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			char[] str = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str[j]-'0';
			}
		}
		int ans = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int now = arr[i][j];
				for (int k = 0; k < N; k++) {
					if (i+k < N && j+k < M && now == arr[i+k][j] && now == arr[i][j+k] && now == arr[i+k][j+k]) {
						ans = Math.max(ans, (k+1)*(k+1));
					}
				}
			}
		}
		System.out.println(ans);
	}
}