import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        sb.append((1 << N)-1).append('\n');
        hanoi(N, 1, 3, 2);
        System.out.print(sb);
    }

    static void hanoi(int n, int from, int to, int temp) {
        if (n == 0) return;
        hanoi(n-1, from, temp, to);
        sb.append(from).append(' ').append(to).append('\n');
        hanoi(n-1, temp, to, from);
    }
}