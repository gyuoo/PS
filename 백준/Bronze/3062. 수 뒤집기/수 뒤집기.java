import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-->0) {
            StringBuilder sb2 = new StringBuilder();
            String str = br.readLine();
            for (int i = str.length()-1; i >= 0; i--) sb2.append(str.charAt(i));
            int sum = Integer.parseInt(str) + Integer.parseInt(new String(sb2));
            str = Integer.toString(sum);
            boolean flag = true;
            for (int i = 0; i < str.length()/2; i++) {
                if (str.charAt(i) == str.charAt(str.length()-1-i)) continue;
                flag = false;
                break;
            }
            sb.append(flag ? "YES" : "NO").append('\n');
        }
        System.out.println(sb);
    }
}