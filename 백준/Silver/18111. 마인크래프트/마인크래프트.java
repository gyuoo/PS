import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		int max = 0, min = 256;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int num = Integer.parseInt(st.nextToken());
				arr[i][j] = num;
				max = Math.max(max, num);
				min = Math.min(min, num);
			}
		}
		int time = Integer.MAX_VALUE, height = 0;
		for (int h = min; h <= max; h++) {
			int lowCnt = 0, highCnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] > h) highCnt += arr[i][j]-h;
					else if (arr[i][j] < h)	lowCnt += h-arr[i][j];
				}
			}
			if (B+highCnt-lowCnt >= 0 && highCnt*2+lowCnt <= time) {
				time = highCnt*2+lowCnt;
				height = h;
			}
		}
		System.out.println(time + " " + height);
	}	
}