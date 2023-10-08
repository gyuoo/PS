import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		int ans = 0;
		if (str.length == 4) ans = 20;
		else if (str.length == 3) {
			if (str[1] == '0') ans = 10+str[2]-'0';
			else ans = 10+str[0]-'0';
		}
		else ans = str[0]+str[1]-'0'*2;
		System.out.println(ans);
	}
}