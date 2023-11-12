import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        while (N-->0) {
            if (str.equals(br.readLine())) ans++;
        }
        System.out.println(ans);
    }
}