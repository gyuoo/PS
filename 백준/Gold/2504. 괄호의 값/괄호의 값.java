import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        boolean flag = true, mul = false;
        int ans = 0, val = 1;
        for (char c : str) {
            if (c == '(') {
                stack.push(c);
                val *= 2;
                mul = true;
            }
            else if (c == '[') {
                stack.push(c);
                val *= 3;
                mul = true;
            }
            else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    flag = false;
                    break;
                }
                if (mul) {
                    ans += val;
                    mul = false;
                }
                val /= 2;
                stack.pop();
            }
            else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    flag = false;
                    break;
                }
                if (mul) {
                    ans += val;
                    mul = false;
                }
                val /= 3;
                stack.pop();
            }
        }
        System.out.print(!flag || !stack.isEmpty() ? 0 : ans);
    }
}