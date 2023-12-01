import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String str = br.readLine();
        System.out.println(str.contains("11") || str.contains("22") ? "No" : "Yes");
    }
}