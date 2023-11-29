import java.io.*;

public class Main {
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-->0) {
            String str = br.readLine();
            ans = 0;
            sb.append(isPalindrome(str)).append(' ').append(ans).append('\n');
        }
        System.out.println(sb);
    }
    static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }
    static int recursion(String s, int l, int r){
        ans++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
}