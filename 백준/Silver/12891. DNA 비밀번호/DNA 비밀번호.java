import java.io.*;
import java.util.*;

public class Main {
	static int[] tempCnt, minCnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken()), P = Integer.parseInt(st.nextToken()), ans = 0;
		char[] dna = {'A', 'C', 'G', 'T'}, temp = br.readLine().toCharArray();
		tempCnt = new int[4];
		minCnt = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) minCnt[i] = Integer.parseInt(st.nextToken());
		for (int i = 0; i < P; i++) {
			for (int j = 0; j < 4; j++) {
				if (temp[i] == dna[j]) {
					tempCnt[j]++;
					break;
				}
			}
		}
		if (check()) ans++;
		for (int i = 0; i < S-P; i++) {
			for (int j = 0; j < 4; j++) {
				if (temp[i] == dna[j]) tempCnt[j]--;
				if (temp[i+P] == dna[j]) tempCnt[j]++;
			}
			if (check()) ans++;
		}
		System.out.println(ans);
	}
	static boolean check() {
		for (int i = 0; i < 4; i++) {
			if (tempCnt[i] < minCnt[i]) return false;
		}
		return true;
	}
}