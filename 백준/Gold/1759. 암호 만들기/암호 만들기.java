import java.io.*;
import java.util.*;

public class Main {
    static int L, C;
    static char[] arr, vowels = {'a', 'e', 'i', 'o', 'u'};
    static boolean[] used;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) arr[i] = st.nextToken().charAt(0);
        Arrays.sort(arr);
        used = new boolean[C];
        password(0, 0);
        System.out.println(sb);
    }
    static void password(int idx, int cnt) {
        if (cnt == L) {
            int vowel = 0, consonant = 0;
            for (int i = 0; i < C; i++) {
                if (used[i]) {
                    boolean flag = false;
                    for (char v : vowels) {
                        if (v == arr[i]) {
                            vowel++;
                            flag = true;
                        }
                    }
                    if (!flag) consonant++;
                }
            }
            if (vowel < 1 || consonant < 2) return;
            for (int i = 0; i < C; i++) {
                if (used[i]) sb.append(arr[i]);
            }
            sb.append('\n');
            return;
        }
        if (idx == C) return;
        used[idx] = true;
        password(idx+1, cnt+1);
        used[idx] = false;
        password(idx+1, cnt);
    }
}