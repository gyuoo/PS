import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int lv = Integer.parseInt(st.nextToken());
        String str = st.nextToken();
        if (str.equals("miss")) lv *= 0;
        else if (str.equals("bad")) lv *= 200;
        else if (str.equals("cool")) lv *= 400;
        else if (str.equals("great")) lv *= 600;
        else lv *= 1000;
        System.out.println(lv);
    }
}