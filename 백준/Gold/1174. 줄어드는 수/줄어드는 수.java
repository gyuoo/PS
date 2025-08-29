import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Long> li = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (long i = 0; i <= 9; i++) {
            li.add(i);
            dfs(i, (int)i);
        }
        Collections.sort(li);
        System.out.print(N <= 1023 ? Long.valueOf(li.get(N-1)) : -1);
    }

    static void dfs(long now, int lastDigit) {
        for (int i = 0; i < lastDigit; i++) {
            long next = now*10+i;
            li.add(next);
            dfs(next, i);
        }
    }
}