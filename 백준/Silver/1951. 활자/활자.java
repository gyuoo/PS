import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length(), N = Integer.parseInt(str);
        long sum = 0, mul = 9;
        for (int i = 1; i < len; i++) {
            sum += mul*i;
            mul *= 10;
        }
        long nine = 0;
        for (int i = 1; i < len; i++) nine = nine*10+9;
        System.out.println((sum+(N-nine)*len)%1234567);
    }
}