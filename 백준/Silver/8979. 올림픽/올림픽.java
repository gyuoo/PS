import java.io.*;
import java.util.*;

public class Main {
	static class Country implements Comparable<Country>{
		int num, gold, silver, bronze, rank;
		public Country(int num, int gold, int silver, int bronze, int rank) {
			this.num = num;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
			this.rank = rank;
		}
		@Override
		public int compareTo(Country o) {
			if (this.gold == o.gold) {
				if (this.silver == o.silver) {
					return Integer.compare(o.bronze, this.bronze);
				}
				return Integer.compare(o.silver, this.silver);
			}
			return Integer.compare(o.gold, this.gold);
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Country[] arr = new Country[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new Country(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
		}
		Arrays.sort(arr);
		arr[0].rank = 1;
		int cnt = 2;
		for (int i = 1; i < N; i++) {
			if (arr[i-1].gold == arr[i].gold && arr[i-1].silver == arr[i].silver && arr[i-1].bronze == arr[i].bronze) arr[i].rank = arr[i-1].rank;
			else arr[i].rank = cnt;
			cnt++;
		}
		for (Country c : arr) {
			if (c.num == K) System.out.print(c.rank);
		}
	}
}