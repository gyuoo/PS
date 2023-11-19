import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int n = 1; n <= N; n++) {
            String[] strArr = br.readLine().split(" ");
            sb.append("Case #").append(n).append(": ");
            for (int i = strArr.length-1; i >= 0; i--) sb.append(strArr[i]).append(' ');
            sb.append('\n');
        }
        System.out.println(sb);
    }
}