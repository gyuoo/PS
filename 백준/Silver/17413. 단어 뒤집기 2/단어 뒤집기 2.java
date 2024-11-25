import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] S = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        boolean isInTag = false;
        for (char c : S) {
            if (c == '<') {
                while (!stack.isEmpty()) sb.append(stack.pop());
                isInTag = true;
            }
            if (isInTag) {
                sb.append(c);
                if (c == '>') isInTag = false;
                continue;
            }
            if (c == ' ') {
                while (!stack.isEmpty()) sb.append(stack.pop());
                sb.append(' ');
                stack = new Stack<>();
            } else stack.push(c);
        }
        while (!stack.isEmpty()) sb.append(stack.pop());
        System.out.print(sb);
    }
}