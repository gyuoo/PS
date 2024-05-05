import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] str = br.readLine().toCharArray();
        for (int i = 0; i < str.length; i++) {
            char c = str[i];
            if ('a' <= c && c <= 'z') sb.append((char)('A'+c-'a'));
            else sb.append((char)(c-'A'+'a'));
        }
        System.out.print(sb);
    }
}