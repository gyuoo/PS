import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
            sb.append(N%C != 0 ? N/C+1 : N/C).append('\n');
        }
        System.out.println(sb);
    }
}