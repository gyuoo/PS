import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        if (s.length() == 0 || s.charAt(0) == '0') {
            System.out.println(0);
            return;
        }
        int len = s.length(), mod = 1_000_000;
        int[] dp = new int[len+1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= len; i++) {
            char c = s.charAt(i-2), c2 = s.charAt(i-1);
            if (c2 != '0') dp[i] = (dp[i]+dp[i-1])%mod;
            int num = (c-'0')*10+(c2-'0');
            if (10 <= num && num <= 26) dp[i] = (dp[i]+dp[i-2])%mod;
        }
        System.out.print(dp[len]%mod);
    }
}