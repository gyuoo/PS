import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(str.contains("M") && str.contains("O") && str.contains("B") && str.contains("I") && str.contains("S") ? "YES" : "NO");
    }
}