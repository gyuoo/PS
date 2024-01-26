import java.io.*;

public class Main {
    static boolean[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        arr = new boolean[]{true, false, false};
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'A') swap(0, 1);
            else if (str.charAt(i) == 'B') swap(1, 2);
            else swap(0, 2);
        }
        for (int i = 0; i < 3; i++) {
            if (arr[i]) System.out.println(i+1);
        }
    }
    static void swap(int a, int b) {
        boolean temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}