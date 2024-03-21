import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] str = br.readLine().toCharArray(), bomb = br.readLine().toCharArray();
        int lenS = str.length, lenB = bomb.length;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < lenS; i++) {
            stack.push(str[i]);
            if (str[i] == bomb[lenB-1] && stack.size() >= lenB) {
                boolean flag = true;
                for (int j = 0; j < lenB; j++) {
                    if (stack.elementAt(stack.size()-1-j) == bomb[lenB-1-j]) continue;
                    flag = false;
                    break;
                }
                if (flag) {
                    for (int j = 0; j < lenB; j++) stack.pop();
                }
            }
        }
        for (char c : stack) sb.append(c);
        System.out.print(sb.length() > 0 ? sb : "FRULA");
    }
}