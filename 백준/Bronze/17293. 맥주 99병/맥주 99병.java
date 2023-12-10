import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = N; i >= 0; i--) {
            if (i > 0) sb.append(i);
            else sb.append("No more");
            sb.append(" bottle");
            if (i != 1) sb.append('s');
            sb.append(" of beer on the wall, ");
            if (i > 0) sb.append(i);
            else sb.append("no more");
            sb.append(" bottle");
            if (i != 1) sb.append('s');
            sb.append(" of beer.").append('\n');
            if (i > 0) {
                sb.append("Take one down and pass it around, ");
                if (i-1 > 0) sb.append(i-1);
                else sb.append("no more");
                sb.append(" bottle");
                if (i != 2) sb.append('s');
            }
            else {
                sb.append("Go to the store and buy some more, ").append(N).append(" bottle");
                if (N != 1) sb.append('s');
            }
            sb.append(" of beer on the wall.").append('\n').append('\n');
        }
        System.out.println(sb);
    }
}