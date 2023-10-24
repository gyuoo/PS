import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int sum = 0, min = Integer.MAX_VALUE;
		for (int i = 0; i < 7; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num % 2 == 1) {
				sum += num;
				min = Math.min(min, num);
			}
		}
		if (sum != 0) sb.append(sum).append('\n').append(min);
		else sb.append(-1);
		System.out.println(sb);
	}
}