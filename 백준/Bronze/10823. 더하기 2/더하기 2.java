import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str;
        while ((str = br.readLine()) != null) sb.append(str);
        StringTokenizer st = new StringTokenizer(sb.toString(), ",");
        int sum = 0;
        while (st.hasMoreTokens()) sum += Integer.parseInt(st.nextToken());
        System.out.println(sum);
    }
}