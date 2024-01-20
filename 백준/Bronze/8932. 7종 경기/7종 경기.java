import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while (T-->0) {
            st = new StringTokenizer(br.readLine());
            sb.append((int)(9.23076*Math.pow(26.7-Integer.parseInt(st.nextToken()), 1.835))+(int)(1.84523*Math.pow(Integer.parseInt(st.nextToken())-75, 1.348))+(int)(56.0211*Math.pow(Integer.parseInt(st.nextToken())-1.5, 1.05))+(int)(4.99087*Math.pow(42.5-Integer.parseInt(st.nextToken()), 1.81))+(int)(0.188807*Math.pow(Integer.parseInt(st.nextToken())-210, 1.41))+(int)(15.9803*Math.pow(Integer.parseInt(st.nextToken())-3.8, 1.04))+(int)(0.11193*Math.pow(254-Integer.parseInt(st.nextToken()), 1.88))).append('\n');
        }
        System.out.println(sb);
    }
}