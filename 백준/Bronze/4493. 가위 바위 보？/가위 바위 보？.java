import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-->0) {
            int n = Integer.parseInt(br.readLine()), score1 = 0, score2 = 0;
            while (n-->0) {
                st = new StringTokenizer(br.readLine());
                char P1 = st.nextToken().charAt(0), P2 = st.nextToken().charAt(0);
                if ((P1 == 'R' && P2 == 'S') || (P1 == 'P' && P2 == 'R') || (P1 == 'S' && P2 == 'P')) score1++;
                else if ((P1 == 'R' && P2 == 'P') || (P1 == 'P' && P2 == 'S') || (P1 == 'S' && P2 == 'R')) score2++;
            }
            sb.append(score1 == score2 ? "TIE" : "Player ").append(score1 != score2 ? score1 > score2 ? '1' : '2' : "").append('\n');
        }
        System.out.println(sb);
    }
}