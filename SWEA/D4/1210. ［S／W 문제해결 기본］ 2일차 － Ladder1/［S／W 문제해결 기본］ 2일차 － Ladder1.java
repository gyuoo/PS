import java.io.*;
import java.util.*;

public class Solution {
    static int ans;
    static int[][] arr;
    static int[][] dir = {{0, -1}, {0, 1}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int t = 1; t <= 10; t++) {
            br.readLine();
            arr = new int[100][100];
            int r = 0, c = 0;
            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if (arr[i][j] == 2) {
                        r = i;
                        c = j;
                    }
                }
            }
            while (r != 0) {
                for (int i = 0; i < 3; i++) {
                    int nr = r+dir[i][0], nc = c+dir[i][1];
                    if (isInRange(nr, nc) && arr[nr][nc] == 1) {
                        arr[r][c] = 0;
                        r = nr;
                        c = nc;
                    }
                }
            }
            sb.append('#').append(t).append(' ').append(c).append('\n');
        }
        System.out.println(sb);
    }
    static boolean isInRange(int nr, int nc) {
        return 0 <= nr && nr < 100 && 0 <= nc && nc < 100;
    }
}