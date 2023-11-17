import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S1 = Integer.parseInt(st.nextToken()), S2 = Integer.parseInt(st.nextToken());
        String str = null;
        boolean flag = true, flag2 = true;
        while (flag && S1-->0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
            if (A == B) continue;
            flag = false;
        }
        if (!flag) str = "Wrong Answer";
        while (flag2 && S2-->0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
            if (A == B) continue;
            flag2 = false;
        }
        if (flag && !flag2) str = "Why Wrong!!!";
        System.out.println(flag && flag2 ? "Accepted" : str);
    }
}