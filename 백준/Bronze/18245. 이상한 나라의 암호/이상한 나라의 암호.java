import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str;
        int dist = 2;
        while (!(str = br.readLine()).equals("Was it a cat I saw?")) {
            StringBuilder word = new StringBuilder();
            for (int i = 0; i < str.length(); i+=dist) word.append(str.charAt(i));
            sb.append(word).append('\n');
            dist++;
        }
        System.out.println(sb);
    }
}