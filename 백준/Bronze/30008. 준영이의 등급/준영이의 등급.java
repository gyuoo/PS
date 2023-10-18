import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		while (K-->0) {
			int per = Integer.parseInt(st.nextToken())*100/N;
			if (per <= 4) sb.append(1);
			else if (per <= 11) sb.append(2);
			else if (per <= 23) sb.append(3);
			else if (per <= 40) sb.append(4);
			else if (per <= 60) sb.append(5);
			else if (per <= 77) sb.append(6);
			else if (per <= 89) sb.append(7);
			else if (per <= 96) sb.append(8);
			else sb.append(9);
			sb.append(' ');
		}
		System.out.println(sb);
	}
}