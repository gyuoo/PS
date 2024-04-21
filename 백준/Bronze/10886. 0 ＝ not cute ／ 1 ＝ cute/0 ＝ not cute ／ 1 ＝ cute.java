import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("Junhee is ");
        int N = Integer.parseInt(br.readLine()), cnt = 0;
        for (int i = 0; i < N; i++) {
            if (br.readLine().charAt(0) == '1') cnt++;
            if (cnt > N/2) break;
        }
        sb.append(cnt > N/2 ? "" : "not ").append("cute!");
        System.out.print(sb);
    }
}