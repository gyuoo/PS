import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> hm = new HashMap<>();
		while (N-->0) {
			st = new StringTokenizer(br.readLine(), ".");
			st.nextToken();
			String str = st.nextToken();
			hm.put(str, hm.getOrDefault(str, 0)+1);
		}
		String[] arr = new String[hm.size()];
		int idx = 0;
		for (String s : hm.keySet()) {
			arr[idx] = s;
			idx++;
		}
		Arrays.sort(arr);
		for (String s : arr) sb.append(s).append(' ').append(hm.get(s)).append('\n');
		System.out.println(sb);
	}
}