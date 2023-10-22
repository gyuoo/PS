import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		int D = Integer.parseInt(br.readLine());
		for (int i = L; i >= 0; i--) {
			A -= C;
			B -= D;
			if (A <= 0 && B <= 0) {
				System.out.println(i-1);
				break;
			}
		}
	}
}