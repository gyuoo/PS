import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int M, N;
    static int[][] map, dp, dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        dp = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        System.out.print(dfs(0, 0));
    }

    static int dfs(int r, int c) {
        if (r == M-1 && c == N-1) {
            return 1;
        }
        if (dp[r][c] != -1) {
            return dp[r][c];
        }
        dp[r][c] = 0;
        for (int d = 0; d < 4; d++) {
            int nr = r+dir[d][0], nc = c+dir[d][1];
            if (!isInRange(nr, nc) || map[nr][nc] >= map[r][c]) continue;
            dp[r][c] += dfs(nr, nc);
        }
        return dp[r][c];
    }

    static boolean isInRange(int nr, int nc) {
        return 0 <= nr && nr < M && 0 <= nc && nc < N;
    }
}