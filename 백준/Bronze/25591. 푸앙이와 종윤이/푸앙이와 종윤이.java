import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
        int a = 100-A, b = 100-B, c = 100-a-b, d = a*b;
        int[] arr = {a, b, c, d, d/100, d%100};
        for (int i : arr) sb.append(i).append(' ');
        sb.append('\n').append(c+d/100).append(' ').append(d%100);
        System.out.println(sb);
    }
}