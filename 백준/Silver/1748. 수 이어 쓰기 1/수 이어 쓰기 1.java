import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line), ans = 0, num = line.length(), nine = 0;
        for (int i = 1; i < line.length(); i++) nine = nine*10+9;
        while (N > 0) {
            ans += (N-nine)*num;
            N = nine;
            nine /= 10;
            num--;
        }
        System.out.println(ans);
    }
}