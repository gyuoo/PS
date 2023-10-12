import java.io.*;
import java.util.*;

public class Main {
	 public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sumA = 0, sumB = 0;
		while (st.hasMoreTokens()) sumA += Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) sumB += Integer.parseInt(st.nextToken());
		System.out.println(Math.max(sumA, sumB));
	}
}