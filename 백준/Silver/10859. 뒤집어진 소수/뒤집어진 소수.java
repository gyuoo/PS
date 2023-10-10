import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		long N = Long.parseLong(str);
		boolean flag = true;
		if (!isPrime(N)) flag = false;
		else {
			char[] revN = new StringBuilder(str).reverse().toString().toCharArray();
			for (int i = 0; i < revN.length; i++) {
				if (revN[i] == '3' || revN[i] == '4' || revN[i] == '7') {
					flag = false;
					break;
				}
				else if (revN[i] == '6') revN[i] = '9';
				else if (revN[i] == '9') revN[i] = '6';
			}
			if (!isPrime(Long.parseLong(new String(revN)))) flag = false;
		}
		System.out.println(flag ? "yes" : "no");
	}
	static boolean isPrime(long n) {
		if (n == 1) return false;
		for (long i = 2; i*i <= n; i++) {
			if (n % i == 0) return false;
		}
		return true;
	}
}