import java.io.*;
import java.util.*;

public class Main {
	static int N, K;
	static int[] team;
	static int[][] info;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		info = new int[N][N];
		for (int i = 0; i < N; i++) Arrays.fill(info[i], 200);
		while (M-->0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1, b = Integer.parseInt(st.nextToken())-1;
			info[a][b] = 1;
			info[b][a] = 1;
		}
		team = new int[N];
		K = 1;
		setDistance();
		for (int i = 0; i < N; i++) {
			if (team[i] != 0) continue;
			findTeam(i);
			K++;
		}
		sb.append(K-1).append('\n');
		int[] minArr = new int[K], maxArr = new int[K], cnt = new int[K];
		Arrays.fill(maxArr, 200);
		for (int t = 1; t < K; t++) {
            for (int i = 0; i < N; i++) {
            	int max = 0;
            	if (t == team[i]) {
            		if (cnt[t]++ == 0) minArr[t] = i+1;
            		for (int j = 0; j < N; j++) {
            			if (info[i][j] == 200) continue;
            			max = Math.max(max, info[i][j]);
            		}
            	}
            	if (max > 0 && maxArr[t] > max) {
                    maxArr[t] = max;
                    minArr[t] = i+1;
                }
            }
        }
		Arrays.sort(minArr);
		for (int i = 1; i < K; i++) sb.append(minArr[i]).append('\n');
		System.out.print(sb);
	}
	
	static void setDistance() {
		for (int m = 0; m < N; m++) {
			for (int s = 0; s < N; s++) {
				for (int e = 0; e < N; e++) {
					if (info[s][m] == 200 || info[m][e] == 200 || s == e) continue;
					info[s][e] = Math.min(info[s][e], info[s][m]+info[m][e]);
				}
			}
		}
	}
	
	static void findTeam(int num) {
		team[num] = K;
		for (int i = 0; i < N; i++) {
			if (info[i][num] == 200 || team[i] != 0 || i == num) continue;
			findTeam(i);
		}
	}
}