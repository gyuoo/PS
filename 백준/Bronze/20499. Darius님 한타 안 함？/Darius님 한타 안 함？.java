import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "/");
        int KA = Integer.parseInt(st.nextToken()), D = Integer.parseInt(st.nextToken());
        KA += Integer.parseInt(st.nextToken());
        System.out.println(KA < D || D == 0 ? "hasu" : "gosu");
    }
}