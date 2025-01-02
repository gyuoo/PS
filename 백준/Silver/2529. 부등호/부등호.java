import java.io.*;
import java.util.*;

public class Main {
    static int k;
    static int[] filledNums;
    static char[] arr;
    static boolean[] used;
    static ArrayList<String> result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new char[k+1];
        for (int i = 1; i <= k; i++) arr[i] = st.nextToken().charAt(0);
        filledNums = new int[k+1];
        result = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            used = new boolean[10];
            fillNumbers(i, 0);
        }
        System.out.println(result.get(result.size()-1));
        System.out.print(result.get(0));
    }

    static void fillNumbers(int prev, int idx) {
        if (idx == k+1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <= k; i++) {
                sb.append(filledNums[i]);
            }
            result.add(sb.toString());
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (used[i]) continue;
            if (arr[idx] == '>') {
                if (prev < i) continue;
            } else {
                if (prev > i) continue;
            }
            used[i] = true;
            filledNums[idx] = i;
            fillNumbers(i, idx+1);
            used[i] = false;
        }
    }
}