import java.io.*;
import java.util.*;

public class Main {
    static int ans;
    static ArrayList<Integer> al = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) al.add(Integer.parseInt(st.nextToken()));
        ans = 0;
        simulate(N, 0);
        System.out.print(ans);
    }

    static void simulate(int len, int sum) {
        if (len == 2) {
            ans = Math.max(ans, sum);
            return;
        }
        for (int i = 1; i < len-1; i++) {
            int temp = al.get(i), val =  al.get(i-1)*al.get(i+1);
            al.remove(i);
            simulate(len-1, sum+val);
            al.add(i, temp);
        }
    }
}