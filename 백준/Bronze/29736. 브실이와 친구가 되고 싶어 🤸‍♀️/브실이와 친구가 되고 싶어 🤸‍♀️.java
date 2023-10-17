import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken()), X = Integer.parseInt(st.nextToken());
		int ans = 0;
		for (int i = K-X; i <= K+X; i++) {
			if (A <= i && i <= B) ans++;
		}
		System.out.println(ans != 0 ? ans : "IMPOSSIBLE");
	}
}