import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int idx = 1;
        while (idx <= 5) {
            String str = br.readLine();
            if (str.contains("FBI")) sb.append(idx).append(' ');
            idx++;
        }
        System.out.println(sb.length() > 0 ? sb : "HE GOT AWAY!");
    }
}