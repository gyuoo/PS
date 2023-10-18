import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int nA = Integer.parseInt(st.nextToken()), nB = Integer.parseInt(st.nextToken());
		HashSet<Integer> hs = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < nA; i++) hs.add(Integer.parseInt(st.nextToken()));
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < nB; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (hs.contains(num)) hs.remove(num);
		}
		ArrayList<Integer> al = new ArrayList<>();
		for (int i : hs) al.add(i);
		Collections.sort(al);
		if (al.size() > 0) {
			sb.append(al.size()).append('\n');
			for (int i : al) sb.append(i).append(' ');
		}
		else sb.append(0);
		System.out.println(sb);
	}
}