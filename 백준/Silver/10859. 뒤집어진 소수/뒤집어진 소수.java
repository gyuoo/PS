import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] charN = br.readLine().toCharArray();
		long longN = Long.parseLong(new String(charN));
		if (longN == 1) {
			System.out.println("no");
			System.exit(0);
		}
		int len = charN.length;
		char[] charN2 = new char[len];
		for (int i = 0; i < len; i++) {
			if (charN[i] == '3' || charN[i] == '4' || charN[i] == '7') {
				System.out.println("no");
				System.exit(0);
			}
			else if (charN[len-i-1] == '6') charN2[i] = '9';
			else if (charN[len-i-1] == '9')	charN2[i] = '6';
			else charN2[i] = charN[len-i-1];
		}
		long longN2 = Long.parseLong(new String(charN2));
		for (long i = 2; i*i <= longN; i++) {
			if (longN % i == 0) {
				System.out.println("no");
				System.exit(0);
			}
		}
		for (long i = 2; i*i <= longN2; i++) {
			if (longN2 % i == 0) {
				System.out.println("no");
				System.exit(0);
			}
		}
		System.out.println("yes");
	}
}