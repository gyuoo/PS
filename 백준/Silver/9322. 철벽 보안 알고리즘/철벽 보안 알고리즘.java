import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while (T-->0) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            HashMap<String, Integer> hm = new HashMap<>();
            HashMap<Integer, String> hm2 = new HashMap<>();
            for (int i = 0; i < n; i++) hm.put(st.nextToken(), i);
            st = new StringTokenizer(br.readLine());
            int[] location = new int[n];
            for (int i = 0; i < n; i++) location[i] = hm.get(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) hm2.put(location[i], st.nextToken());
            for (int i = 0; i < n; i++) sb.append(hm2.get(i)).append(' ');
            sb.append('\n');
        }
        System.out.println(sb);
    }
}