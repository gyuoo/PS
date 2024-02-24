import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine(), T = br.readLine();
		while (S.length() != T.length()) {
			if (T.charAt(T.length()-1) == 'A') T = T.substring(0, T.length()-1);
			else T = new StringBuilder(T.substring(0, T.length()-1)).reverse().toString();
		}
		System.out.println(S.equals(T) ? 1 : 0);
	}
}