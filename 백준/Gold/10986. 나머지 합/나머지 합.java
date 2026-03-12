import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long[] cnt = new long[M];
        long prefix = 0;
        cnt[0] = 1;
        for (int i = 0; i < N; i++) {
            prefix += Long.parseLong(st.nextToken());
            int r = (int)(prefix%M);
            cnt[r]++;
        }
        long ans = 0;
        for (int r = 0; r < M; r++) {
            long k = cnt[r];
            ans += k*(k-1)/2;
        }
        System.out.print(ans);
    }
}
