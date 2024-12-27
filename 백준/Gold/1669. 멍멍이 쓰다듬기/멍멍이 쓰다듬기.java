import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken()), Y = Integer.parseInt(st.nextToken()), diff = Y-X;
        int range = (int)Math.sqrt(diff), ans = range*2;
        if (Math.sqrt(diff)%1 == 0) ans--;
        else if ((int)Math.pow(range, 2)+range < diff) ans++;
        System.out.print(Math.max(0, ans));
    }
}