import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), start = 0, end = 0, cnt = 0, max = 1;
        char[] str = br.readLine().toCharArray();
        int[] abc = new int[26];
        while (end < str.length) {
            if (abc[str[end]-'a']++ == 0) cnt++;
            while (N < cnt && start < end) {
                if (--abc[str[start++]-'a'] == 0) cnt--;
            }
            max = Math.max(max, end++-start+1);
        }
        System.out.print(max);
    }
}