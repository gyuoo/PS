import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        if (str.contains("::")) str = str.replace("::", ":zeros:");
        String[] arr = str.split(":");
        int size = 9-arr.length;
        for (String s : arr) {
            if (s.equals("zeros")) {
                while (size --> 0) sb.append("0000").append(':');
            } else {
                for (int i = 0; i < 4-s.length(); i++) sb.append('0');
                sb.append(s).append(':');
            }
        }
        System.out.print(sb.deleteCharAt(sb.length()-1));
    }
}