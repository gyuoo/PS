import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int AB = Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken()), C = Integer.parseInt(br.readLine())*2;
        System.out.println(AB >= C ? AB-C : AB);
    }
}