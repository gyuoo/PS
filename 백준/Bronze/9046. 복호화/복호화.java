import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-->0) {
            int[] cnt = new int[26];
            char[] str = br.readLine().toCharArray();
            for (char c : str) {
                if ('a' <= c && c <= 'z') cnt[c-'a']++;
            }
            int max = 0;
            List<Character> li = new ArrayList<>();
            for (int i = 0; i < 26; i++) max = Math.max(max, cnt[i]);
            for (int i = 0; i < 26; i++) {
                if (cnt[i] == max) li.add((char)(i+'a'));
            }
            if (1 < li.size()) sb.append('?');
            else sb.append(li.get(0));
            sb.append('\n');
        }
        System.out.print(sb);
    }
}