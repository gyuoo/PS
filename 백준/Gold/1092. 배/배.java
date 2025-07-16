import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] crane = new int[N];
        for (int i = 0; i < N; i++) crane[i] = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] box = new int[M];
        for (int i = 0; i < M; i++) box[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(crane);
        Arrays.sort(box);

        if (crane[N-1] < box[M-1]) {
            System.out.println(-1);
            return;
        }

        boolean[] moved = new boolean[M];
        int[] pos = new int[N];
        Arrays.fill(pos, M-1);
        int moveCnt = 0, ans = 0;
        while (moveCnt < M) {
            for (int i = N-1; 0 <= i; i--) {
                while (0 <= pos[i]) {
                    if (!moved[pos[i]] && box[pos[i]] <= crane[i]) {
                        moved[pos[i]] = true;
                        moveCnt++;
                        pos[i]--;
                        break;
                    }
                    pos[i]--;
                }
            }
            ans++;
        }
        System.out.print(ans);
    }
}