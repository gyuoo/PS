import java.io.*;
import java.util.*;

public class Main {
	static class Person implements Comparable<Person> {
		String name;
		int height;
		public Person(String name, int height) {
			this.name = name;
			this.height = height;
		}
		@Override
		public int compareTo(Person o) {
			return Integer.compare(o.height, this.height);
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N;
		while ((N = Integer.parseInt(br.readLine())) != 0) {
			Person[] arr = new Person[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i] = new Person(st.nextToken(), (int)(Double.parseDouble(st.nextToken())*100));
			}
			Arrays.sort(arr);
			int top = arr[0].height;
			for (int i = 0; i < N; i++) {
				if (top == arr[i].height) sb.append(arr[i].name).append(' ');
				else break;
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}