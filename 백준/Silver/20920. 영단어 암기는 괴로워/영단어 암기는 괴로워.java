import java.io.*;
import java.util.*;

public class Main {
	static class Word implements Comparable<Word>{
		String str;
		int cnt;
		public Word(String str, int cnt) {
			this.str = str;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Word o) {
			if (this.cnt == o.cnt) {
				if (this.str.length() == o.str.length()) return this.str.compareTo(o.str);
				return Integer.compare(o.str.length(), this.str.length());
			}
			return Integer.compare(o.cnt, this.cnt);
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> hm = new HashMap<>();
		while (N-->0) {
			String str = br.readLine();
			if (str.length() >= M) hm.put(str, hm.containsKey(str) ? hm.get(str)+1 : 1);
		}
		PriorityQueue<Word> pq = new PriorityQueue<>();
		for (String s : hm.keySet()) {
			pq.add(new Word(s, hm.get(s)));
		}
		while (!pq.isEmpty()) {
			Word w = pq.poll();
			sb.append(w.str).append('\n');
		}
		System.out.println(sb);
	}
}