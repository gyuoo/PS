import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] arr = new char[R][C];
		for (int i = 0; i < R; i++) {
			char[] str = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				arr[i][j] = str[j];
			}
		}
		ArrayList<String> al = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			String str = "";
			for (int j = 0; j < C; j++) {
				if (arr[i][j] != '#') str += arr[i][j];
				if (j == C-1 || arr[i][j] == '#') {
					if (str.length() >= 2) al.add(str);
					str = "";
				}
			}
		}
		for (int i = 0; i < C; i++) {
			String str = "";
			for (int j = 0; j < R; j++) {
				if (arr[j][i] != '#') str += arr[j][i];
				if (j == R-1 || arr[j][i] == '#') {
					if (str.length() >= 2) al.add(str);
					str = "";
				}
			}
		}
		Collections.sort(al);
		System.out.println(al.get(0));
	}
}