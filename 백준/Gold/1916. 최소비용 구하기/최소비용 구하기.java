import java.io.*;
import java.util.*;

public class Main {
	static class Bus implements Comparable<Bus>{
		int destination, cost;
		Bus (int destination, int cost) {
			this.destination = destination;
			this.cost = cost;
		}
		@Override
		public int compareTo(Bus o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	static int[] minCosts;
	static ArrayList<Bus>[] info;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine()), M = Integer.parseInt(br.readLine());
		info = new ArrayList[N+1];
		minCosts = new int[N+1];
		Arrays.fill(minCosts, Integer.MAX_VALUE);
		for (int i = 0; i <= N; i++) info[i] = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			info[Integer.parseInt(st.nextToken())].add(new Bus(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken()), end = Integer.parseInt(st.nextToken());
		minCosts[start] = 0;
		findMinCost(start);
		System.out.print(minCosts[end]);
	}
	static void findMinCost(int start) {
		PriorityQueue<Bus> pq = new PriorityQueue<>();
		pq.offer(new Bus(start, 0));
		while (!pq.isEmpty()) {
			Bus now = pq.poll();
			if (minCosts[now.destination] < now.cost) continue;
			for (Bus next : info[now.destination]) {
				if (minCosts[next.destination] > now.cost+next.cost) {
					minCosts[next.destination] = now.cost+next.cost;
					pq.offer(new Bus(next.destination, minCosts[next.destination]));
				}
			}
		}
	}
}