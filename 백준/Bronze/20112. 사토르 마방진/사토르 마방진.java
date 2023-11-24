import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N][N];
        for (int i = 0; i < N; i++) arr[i] = br.readLine().toCharArray();
        boolean flag = true;
        loop:
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                if (arr[i][j] != arr[j][i]) {
                    flag = false;
                    break loop;
                }
            }
        }
        System.out.println(flag ? "YES" : "NO");
    }
}