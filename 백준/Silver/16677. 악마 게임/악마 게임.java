import java.io.*;
import java.util.*;

public class Main {
    static class Word implements Comparable<Word> {
        String w;
        double g;
        public Word (String w, double g) {
            this.w = w;
            this.g = g;
        }
        @Override
        public int compareTo(Word o) {
            return Double.compare(o.g, this.g);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        char[] m = br.readLine().toCharArray();
        int N = Integer.parseInt(br.readLine());
        ArrayList<Word> al = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String w = st.nextToken();
            int g = Integer.parseInt(st.nextToken());
            int cnt = 0, idx = 0;
            for (int j = 0; j < w.length(); j++) {
                if (m[idx] == w.charAt(j)) {
                    cnt++;
                    idx++;
                }
                if (cnt == m.length) {
                    al.add(new Word(w, (double)g/(w.length()-m.length)));
                    break;
                }
            }
        }
        Collections.sort(al);
        System.out.println(!al.isEmpty() ? al.get(0).w : "No Jam");
    }
}