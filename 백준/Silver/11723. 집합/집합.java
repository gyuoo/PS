import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        HashSet<Integer> hs = new HashSet<>();
        int M = Integer.parseInt(br.readLine());
        while (M-->0) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if (str.equals("all")) {
                hs = new HashSet<>();
                for (int i = 1; i <= 20; i++) hs.add(i);
            }
            else if (str.equals("empty")) hs = new HashSet<>();
            else {
                int x = Integer.parseInt(st.nextToken());
                if (str.equals("add")) hs.add(x);
                else if (str.equals("remove")) hs.remove(x);
                else if (str.equals("check")) sb.append(hs.contains(x) ? 1 : 0).append('\n');
                else if (str.equals("toggle")) {
                    if (hs.contains(x)) hs.remove(x);
                    else hs.add(x);
                }
            }
        }
        System.out.print(sb);
    }
}