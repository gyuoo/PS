import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static String target;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(target = br.readLine());
        arr = new int[N];
        int[] arr2 = new int[N];
        for (int i = 0; i < N; i++) arr2[i] = arr[i] = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        Arrays.sort(arr2);
        for (int i = N-1; 0 < i; i--) sb.append(arr2[i]).append(' ');
        sb.append(arr2[0]);
        String ans = "-1";
        if (!sb.toString().equals(target)) {
            findNext();
            sb = new StringBuilder();
            for (int i = 0; i < N-1; i++) {
                sb.append(arr[i]).append(' ');
            }
            ans = sb.append(arr[N-1]).toString();
        }
        System.out.print(ans);
    }
    static void findNext() {
        int i = N-1, j = N-1;
        while (0 < i && arr[i-1] >= arr[i]) i--;
        while (arr[j] <= arr[i-1]) j--;
        int temp = arr[i-1];
        arr[i-1] = arr[j];
        arr[j] = temp;
        j = N-1;
        while (i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}