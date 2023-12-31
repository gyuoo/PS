import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int sum = Integer.parseInt(br.readLine())+Integer.parseInt(br.readLine())+Integer.parseInt(br.readLine())+Integer.parseInt(br.readLine());
        sb.append(sum/60).append('\n').append(sum%60);
        System.out.println(sb);
    }
}