import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine())%8, ans;
        if (n == 1) ans = 1;
        else if (n == 2 || n == 0) ans = 2;
        else if (n == 3 || n == 7) ans = 3;
        else if (n == 4 || n == 6) ans = 4;
        else ans = 5;
        System.out.println(ans);
    }
}