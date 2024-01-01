import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), sum = 0;
        while (N-->0) {
            String str = br.readLine();
            if (str.equals("136 68")) sum += 1;
            else if (str.equals("142 68")) sum += 5;
            else if (str.equals("148 68")) sum += 10;
            else sum += 50;
        }
        System.out.println(sum*1000);
    }
}