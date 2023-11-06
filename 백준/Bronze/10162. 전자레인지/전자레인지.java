import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        if (T % 10 == 0) {
            sb.append(T/300).append(' ');
            T %= 300;
            sb.append(T/60).append(' ');
            T %= 60;
            sb.append(T/10);
        }
        else sb.append(-1);
        System.out.println(sb);
    }
}