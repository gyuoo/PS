import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(str.equals("M") ? "MatKor" : str.equals("W") ? "WiCys" : str.equals("C") ? "CyKor" : str.equals("A") ? "AlKor" : "$clear");
    }
}