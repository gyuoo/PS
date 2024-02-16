import java.io.*;
import java.util.*;

public class Main {
	static class Player implements Comparable<Player>{
		int idx, power, ring;
		public Player(int idx, int power, int ring) {
			super();
			this.idx = idx;
			this.power = power;
			this.ring = ring;
		}
		@Override
		public int compareTo(Player o) {
			return Integer.compare(o.power+this.power*o.ring, this.power+o.power*this.ring);
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Player[] players = new Player[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int power = Integer.parseInt(st.nextToken());
			int ring = Integer.parseInt(st.nextToken());
			Player p = new Player(i+1, power, ring);
			players[i] = p;
		}
		Arrays.sort(players);
		for (int i = 0; i < N; i++) {
			sb.append(players[i].idx).append('\n');
		}
		System.out.println(sb);
	}
}