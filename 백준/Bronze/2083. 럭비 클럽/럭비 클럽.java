import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String str;
		while (!(str = br.readLine()).equals("# 0 0")){
			st = new StringTokenizer(str);
			sb.append(st.nextToken()).append(' ');
			int age = Integer.parseInt(st.nextToken()), weight = Integer.parseInt(st.nextToken());
			if (age > 17 || weight >= 80) sb.append("Senior");
			else sb.append("Junior");
			sb.append('\n');
		}
		System.out.println(sb);
	}
}