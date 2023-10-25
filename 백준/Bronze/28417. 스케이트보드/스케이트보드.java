import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int winner = 0;
		while (N-->0) {
			st = new StringTokenizer(br.readLine());
			int run = Math.max(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			int[] trickArr = new int[5];
			for (int i = 0; i < 5; i++) trickArr[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(trickArr);
			int trick = trickArr[3] + trickArr[4];
			winner = Math.max(winner, run+trick);
		}
		System.out.println(winner);
	}
}