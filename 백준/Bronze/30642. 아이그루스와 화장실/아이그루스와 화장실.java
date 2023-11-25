import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String str = br.readLine();
        int K = Integer.parseInt(br.readLine()), F = K;
        if ((str.equals("annyong") && K % 2 == 0) || (str.equals("induck") && K % 2 == 1)) F = K-1;
        System.out.println(F != 0 ? F : 2);
    }
}