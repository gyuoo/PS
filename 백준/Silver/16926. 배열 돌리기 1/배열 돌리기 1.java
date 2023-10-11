import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int layer = Math.min(N/2, M/2);
		if (N % 2 == 1 && M % 2 == 1) layer++;
		int[][] ans = new int[N][M];
		for (int l = 0; l < layer; l++) {
			int length = (N-l*2)*2 + (M-l*2)*2 - 4;
			if (length == 0) length = 1;
			else if (length % 2 == 1) length++;
			int[] layerNum = new int[length];
			for (int i = 0; i < length; i++) {
				if (i < M-l*2-1) layerNum[i] = arr[l][l+i];
				else if (i < M+N-l*4-2) layerNum[i] = arr[l+i-(M-l*2-1)][M-1-l];
				else if (i < M*2+N-l*6-3) layerNum[i] = arr[N-1-l][M-1-l+(M+N-l*4-2)-i];
				else layerNum[i] = arr[N-1-l+(M*2+N-l*6-3)-i][l];
			}
			int move = R % length;
			for (int i = 0; i < length; i++) {
				if (i < M-l*2-1) ans[l][l+i] = layerNum[(i+move)%length];
				else if (i < M+N-l*4-2) ans[l+i-(M-l*2-1)][M-1-l] = layerNum[(i+move)%length];
				else if (i < M*2+N-l*6-3) ans[N-1-l][M-1-l+(M+N-l*4-2)-i] = layerNum[(i+move)%length];
				else ans[N-1-l+(M*2+N-l*6-3)-i][l] = layerNum[(i+move)%length];
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(ans[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}