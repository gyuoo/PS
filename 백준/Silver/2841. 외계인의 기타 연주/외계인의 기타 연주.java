import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), ans = 0;
        Stack<Integer>[] stacks = new Stack[6];
        for (int i = 0; i < 6; i++) stacks[i] = new Stack<>();
        while (N-->0) {
            st = new StringTokenizer(br.readLine());
            int note = Integer.parseInt(st.nextToken())-1, fret = Integer.parseInt(st.nextToken());
            Stack<Integer> now = stacks[note];
            while (!now.isEmpty() && now.peek() > fret) {
                now.pop();
                ans++;
            }
            if (now.isEmpty() || now.peek() < fret) {
                now.push(fret);
                ans++;
            }
        }
        System.out.println(ans);
    }
}