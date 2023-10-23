import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N*5][N*5];
        for (int i = 0; i < N*5; i++){
            for (int j = 0; j < N*5; j++){
                if (j < N || j >= N*4) arr[i][j] = '@';
                else if ((N*2 <= i && i < N*3) || (N*4 <= i && i < N*5)) arr[i][j] = '@';
                else arr[i][j] = ' ';
            }
        }
        for (int i = 0; i < N*5; i++) sb.append(arr[i]).append('\n');
        System.out.println(sb);
    }
}