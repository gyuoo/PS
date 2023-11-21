import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = i+1;
        while (M-->0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1, end = Integer.parseInt(st.nextToken())-1;
            int[] arr2 = new int[end-start+1];
            for (int i = 0; i < arr2.length; i++) arr2[i] = arr[end-i];
            int idx = 0;
            for (int i = start; i <= end; i++) arr[i] = arr2[idx++];
        }
        for (int i : arr) sb.append(i).append(' ');
        System.out.println(sb);
    }
}