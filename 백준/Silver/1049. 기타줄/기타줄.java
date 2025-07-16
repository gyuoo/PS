import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int minSet = Integer.MAX_VALUE, minUnit = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            minSet = Math.min(minSet, Integer.parseInt(st.nextToken()));
            minUnit = Math.min(minUnit, Integer.parseInt(st.nextToken()));
        }
        System.out.print(Math.min(Math.min(N%6 == 0 ? N/6*minSet : (N/6+1)*minSet, N/6*minSet+N%6*minUnit), minUnit*N));
    }
}