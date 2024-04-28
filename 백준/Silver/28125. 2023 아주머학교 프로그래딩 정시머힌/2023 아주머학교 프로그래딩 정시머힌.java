import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        while (N-->0) {
            char[] str = br.readLine().toCharArray();
            StringBuilder sb2 = new StringBuilder();
            int slash = 0, cnt = 0;
            for (int i = 0; i < str.length; i++) {
                char c = str[i];
                if (c == '@') {
                    sb2.append('a');
                    cnt++;
                }
                else if (c == '[') {
                    sb2.append('c');
                    cnt++;
                }
                else if (c == '!') {
                    sb2.append('i');
                    cnt++;
                }
                else if (c == ';') {
                    sb2.append('j');
                    cnt++;
                }
                else if (c == '^') {
                    sb2.append('n');
                    cnt++;
                }
                else if (c == '0') {
                    sb2.append('o');
                    cnt++;
                }
                else if (c == '7') {
                    sb2.append('t');
                    cnt++;
                }
                else if (c == '\\') slash++;
                else if (c == '\'') {
                    sb2.append(slash == 1 ? 'v' : 'w');
                    slash = 0;
                    cnt++;
                }
                else sb2.append(c);
            }
            sb.append(cnt*2 < sb2.length() ? sb2 : "I don't understand").append('\n');
        }
        System.out.print(sb);
    }
}