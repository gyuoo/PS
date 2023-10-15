import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str;
		HashMap<String, Integer> hm = new HashMap<>();
		int num = 0;
		while ((str = br.readLine()) != null) {
			hm.put(str, hm.getOrDefault(str, 0)+1);
			num++;
		}
		ArrayList<String> al = new ArrayList<>();
		for (String s : hm.keySet()) al.add(s);
		Collections.sort(al);
		for (String s : al) {
			sb.append(s).append(' ').append(String.format("%.4f", (double)hm.get(s)/num*100)).append('\n');
		}
		System.out.println(sb);
	}
}