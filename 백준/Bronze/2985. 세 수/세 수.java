import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] arr = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        sb.append(arr[0]);
        if (arr[0]+arr[1] == arr[2]) sb.append('+').append(arr[1]).append('=');
        else if (arr[0]-arr[1] == arr[2]) sb.append('-').append(arr[1]).append('=');
        else if (arr[0]*arr[1] == arr[2]) sb.append('*').append(arr[1]).append('=');
        else if (arr[0]/arr[1] == arr[2]) sb.append('/').append(arr[1]).append('=');
        else if (arr[0] == arr[1]+arr[2]) sb.append('=').append(arr[1]).append('+');
        else if (arr[0] == arr[1]-arr[2]) sb.append('=').append(arr[1]).append('-');
        else if (arr[0] == arr[1]*arr[2]) sb.append('=').append(arr[1]).append('*');
        else if (arr[0] == arr[1]/arr[2]) sb.append('=').append(arr[1]).append('/');
        sb.append(arr[2]);
        System.out.println(sb);
    }
}