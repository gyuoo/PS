import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int M = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[4];
        arr[1] = true;
        while (M-->0){
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            boolean temp = arr[X];
            arr[X] = arr[Y];
            arr[Y] = temp;
        }
        for (int i = 1; i <= 3; i++){
            if (arr[i]) {
                System.out.println(i);
                break;
            }
        }
    }
}