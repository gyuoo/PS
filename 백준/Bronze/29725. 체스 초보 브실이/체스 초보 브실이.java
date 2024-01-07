import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = 0;
        for (int i = 0; i < 8; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < 8; j++) {
                if (line[j] == 'P') ans++;
                else if (line[j] == 'p') ans--;
                else if (line[j] == 'N' || line[j] == 'B') ans += 3;
                else if (line[j] == 'n' || line[j] == 'b') ans -= 3;
                else if (line[j] == 'R') ans += 5;
                else if (line[j] == 'r') ans -= 5;
                else if (line[j] == 'Q') ans += 9;
                else if (line[j] == 'q') ans -= 9;
            }
        }
        System.out.println(ans);
    }
}