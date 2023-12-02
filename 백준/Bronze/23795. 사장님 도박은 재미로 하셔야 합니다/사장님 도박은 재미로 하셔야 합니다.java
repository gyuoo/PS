import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        int sum = 0;
        while (!(str = br.readLine()).equals("-1")) sum += Integer.parseInt(str);
        System.out.println(sum);
    }
}