import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), L = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        boolean[] pipe = new boolean[arr[N-1]+1];
        for (int i = 0; i < N; i++) pipe[arr[i]] = true;
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (pipe[arr[i]]) {
                ans++;
                if (arr[i]+L <= pipe.length) {
                    for (int j = 0; j < L; j++) {
                        pipe[arr[i]+j] = false;
                    }
                }
                else {
                    for (int j = arr[i]; j < pipe.length; j++) {
                        pipe[j] = false;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}