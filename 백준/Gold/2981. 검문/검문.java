import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    static List<Integer> divisors;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int g = 0;
        for (int i = 1; i < N; i++) {
            g = gcd(g, arr[i]-arr[i-1]);
        }
        divisors = new ArrayList<>();
        divisor(g);
        Collections.sort(divisors);
        for (int i : divisors) {
            sb.append(i).append(' ');
        }
        System.out.print(sb);
    }

    static void divisor(int n) {
        for (int i = 1; i*i <= n; i++) {
            if (n%i != 0) continue;
            int val = n/i;
            if (i != 1) divisors.add(i);
            if (i != val) divisors.add(val);
        }
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int r = a%b;
            a = b;
            b = r;
        }
        return a;
    }
}
