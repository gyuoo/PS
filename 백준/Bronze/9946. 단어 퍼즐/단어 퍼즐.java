import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str;
		int num = 1;
		while (!(str = br.readLine()).equals("END")) {
			char[] strArr = str.toCharArray(), strArr2 = br.readLine().toCharArray();
			Arrays.sort(strArr);
			Arrays.sort(strArr2);
			str = new String(strArr);
			String str2 = new String(strArr2);
			sb.append("Case ").append(num).append(": ").append(str.equals(str2)?"same":"different").append('\n');
			num++;
		}
		System.out.println(sb);
	}
}