import java.io.*;

public class Main {
    static int N, ans;
    static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        ans = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                swap(i, j);
            }
        }
        System.out.println(ans);
    }
    static void swap(int r, int c) {
        for (int d = 0; d < 4; d++) {
            int nr = r+dir[d][0], nc = c+dir[d][1];
            if (0 <= nr && nr < N && 0 <= nc && nc < N) {
                if (isSame(r, c, nr, nc)) continue;
                char temp = arr[r][c];
                arr[r][c] = arr[nr][nc];
                arr[nr][nc] = temp;
                ans = Math.max(ans, maxCheck());
                arr[nr][nc] = arr[r][c];
                arr[r][c] = temp;
            }
        }
    }
    static boolean isSame(int r, int c, int nr, int nc) {
        return arr[r][c] == arr[nr][nc];
    }
    static int maxCheck() {
        int max1 = 1, max2 = 1, cnt1 = 1, cnt2 = 1;
        for (int i = 0; i < N; i++) {
            char color1 = 'A', color2 = 'A';
            for (int j = 0; j < N; j++) {
                if (arr[i][j] != color1) {
                    max1 = Math.max(max1, cnt1);
                    cnt1 = 1;
                    color1 = arr[i][j];
                }
                else cnt1++;
                max1 = Math.max(max1, cnt1);
                if (arr[j][i] != color2) {
                    max2 = Math.max(max2, cnt2);
                    cnt2 = 1;
                    color2 = arr[j][i];
                }
                else cnt2++;
                max2 = Math.max(max2, cnt2);
            }
        }
        if (Math.max(max1, max2) == N) {
            System.out.println(N);
            System.exit(0);
        }
        return Math.max(max1, max2);
    }
}