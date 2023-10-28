import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        while (N-->0){
            char[] str = br.readLine().toCharArray();
            sb.append("Do-it").append(str[str.length/2-1]==str[str.length/2]?"":"-Not").append('\n');
        }
        System.out.println(sb);
    }
}