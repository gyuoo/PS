import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		int D = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine()); 
		int sum = 0;
		if (A < 0) {
			sum += C*(-A) + D;
			A = 0;
		}
		System.out.println(sum+(B-A)*E);
	}
}