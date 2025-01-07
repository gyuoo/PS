import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < N; i++) hs.add(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N; i++) hs.remove(st.nextToken());
        System.out.print(hs.iterator().next());
    }
}