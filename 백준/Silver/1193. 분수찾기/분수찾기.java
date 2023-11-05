import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int X = Integer.parseInt(br.readLine()), sum = 0, num = 1;
        while (sum < X) {
            sum += num;
            num++;
        }
        int a = sum-X+1;
        sb.append(num%2==0 ? a : num-a).append('/').append(num%2==0 ? num-a : a);
        System.out.println(sb);
    }
}