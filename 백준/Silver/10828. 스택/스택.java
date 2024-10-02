import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		while (N-->0) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			if (command.equals("push")) stack.push(Integer.parseInt(st.nextToken()));
			else {
				if (command.equals("top")) sb.append(stack.isEmpty() ? -1 : stack.peek());
				else if (command.equals("empty")) sb.append(stack.isEmpty() ? 1 : 0);
				else if (command.equals("size")) sb.append(stack.size());
				else if (command.equals("pop")) sb.append(stack.isEmpty() ? -1 : stack.pop());
				sb.append('\n');
			}
		}
		System.out.print(sb);
	}
}