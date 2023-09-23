import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
		Stack<Integer> s = new Stack<>();
		long ans = 0;
		for (int i = 0; i < N; i++) {
			while (!s.isEmpty() && arr[i] >= s.peek()) s.pop();
			ans += s.size();
			s.push(arr[i]);
		}
		System.out.println(ans);
	}
}