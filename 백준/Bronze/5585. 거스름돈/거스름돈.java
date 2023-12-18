import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 1000-Integer.parseInt(br.readLine()), ans = 0;
        ans += N/500;
        N %= 500;
        ans += N/100;
        N %= 100;
        ans += N/50;
        N %= 50;
        ans += N/10;
        N %= 10;
        ans += N/5;
        N %= 5;
        System.out.println(ans+N);
    }
}