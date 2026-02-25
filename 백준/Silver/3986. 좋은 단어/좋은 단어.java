import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), ans = 0;
        Stack<Character> stack;
        while (N-->0) {
            stack = new Stack<>();
            char[] str = br.readLine().toCharArray();
            if (str.length % 2 == 1) continue;
            for (char c : str) {
                if (!stack.isEmpty() && stack.peek() == c) stack.pop();
                else stack.push(c);
            }
            if (stack.isEmpty()) ans++;
        }
        System.out.print(ans);
    }
}