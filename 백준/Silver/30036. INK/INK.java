import java.io.*;
import java.util.*;

public class Main {
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int I = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		char[] color = br.readLine().toCharArray();
		char[][] stage = new char[N][N];
		int r = 0, c = 0;
		for (int i = 0; i < N; i++) {
			char[] str = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				stage[i][j] = str[j];
				if (str[j] == '@') {
					r = i;
					c = j;
				}
			}
		}
		int ink = 0, cnt = 0;
		char[] commands = br.readLine().toCharArray();
		for (int i = 0; i < K; i++) {
			switch (commands[i]) {
			case 'U':
				if (check(r-1, c) && stage[r-1][c] == '.') {
					stage[r][c] = '.';
					stage[--r][c] = '@';
				}
				break;
			case 'D':
				if (check(r+1, c) && stage[r+1][c] == '.') {
					stage[r][c] = '.';
					stage[++r][c] = '@';
				}
				break;
			case 'L':
				if (check(r, c-1) && stage[r][c-1] == '.') {
					stage[r][c] = '.';
					stage[r][--c] = '@';
				}
				break;
			case 'R':
				if (check(r, c+1) && stage[r][c+1] == '.') {
					stage[r][c] = '.';
					stage[r][++c] = '@';
				}
				break;
			case 'j':
				ink++;
				break;
			case 'J':
				for (int j = 1; j <= ink; j++) {
					for (int k = 0; k <= j; k++) {
						if (check(r+k, c+j-k) && stage[r+k][c+j-k] != '.')
							stage[r+k][c+j-k] = color[cnt%I];
						if (check(r+k, c-(j-k)) && stage[r+k][c-(j-k)] != '.')
							stage[r+k][c-(j-k)] = color[cnt%I];
						if (check(r-k, c-(j-k)) && stage[r-k][c-(j-k)] != '.')
							stage[r-k][c-(j-k)] = color[cnt%I];
						if (check(r-k, c+j-k) && stage[r-k][c+j-k] != '.')
							stage[r-k][c+j-k] = color[cnt%I];
					}
				}
				cnt++;
				ink = 0;
				break;
			}
		}
		for (char[] i : stage) sb.append(i).append('\n');
		System.out.println(sb);
	}
	static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}
}