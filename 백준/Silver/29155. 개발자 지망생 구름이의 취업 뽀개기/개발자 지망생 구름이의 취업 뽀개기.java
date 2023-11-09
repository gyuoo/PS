import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        ArrayList<PriorityQueue<Integer>> al = new ArrayList<>();
        for (int i = 0; i <= 5; i++) al.add(new PriorityQueue<>());
        int[] solve = new int[6];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 5; i++) solve[i] = Integer.parseInt(st.nextToken());
        while (N-->0) {
            st = new StringTokenizer(br.readLine());
            al.get(Integer.parseInt(st.nextToken())).offer(Integer.parseInt(st.nextToken()));
        }
        int sum = 0;
        for (int l = 1; l <= 5; l++) {
            int temp = al.get(l).poll();
            for (int i = 1; i < solve[l]; i++) {
                sum += al.get(l).peek();
                temp = al.get(l).poll();
            }
            sum += temp;
        }
        System.out.println(240+sum);
    }
}