import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
		int sum = 0;
		st = new StringTokenizer(br.readLine());
		while (K-->0) {
			int A = Integer.parseInt(st.nextToken());
			sum += A/2;
			if (A % 2 == 1) sum++;
		}
		System.out.println(sum >= N ? "YES" : "NO");
	}
}