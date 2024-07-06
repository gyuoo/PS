import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()), cnt = 0;
        HashMap<String, ArrayList<String>> hm = new HashMap<>();
        while (N-->0) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken(), ring = st.nextToken();
            if (ring.equals("-")) continue;
            if (hm.containsKey(ring)) hm.get(ring).add(name);
            else {
                ArrayList<String> al = new ArrayList<>();
                al.add(name);
                hm.put(ring, al);
            }
        }
        for (String s : hm.keySet()) {
            if (hm.get(s).size() == 2) {
                cnt++;
                for (String name : hm.get(s)) sb.append(name).append(' ');
                sb.append('\n');
            }
        }
        System.out.println(cnt);
        System.out.print(sb);
    }
}