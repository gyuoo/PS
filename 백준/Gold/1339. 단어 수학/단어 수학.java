import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cnt = new int[26];
        while (N-->0) {
            char[] str = br.readLine().toCharArray();
            int zero = 10, len = str.length;
            for (int i = len-1; 0 <= i; i--) {
                cnt[str[i]-'A'] += (int)Math.pow(zero, len-1-i);
            }
        }
        Arrays.sort(cnt);
        int ans = 0;
        for (int i = 9; 0 < i; i--) ans += i * cnt[16+i];
        System.out.println(ans);
    }
}