import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), max = 0;
        HashMap<String, Integer> hm = new HashMap<>();
        while (N-->0) {
            String str = br.readLine();
            hm.put(str, hm.getOrDefault(str, 0)+1);
            if (max < hm.get(str)) {
                max = hm.get(str);
            }
        }
        ArrayList<String> al = new ArrayList<>();
        for (Map.Entry<String, Integer> e : hm.entrySet()) {
            if (e.getValue() == max) al.add(e.getKey());
        }
        Collections.sort(al);
        System.out.print(al.get(0));
    }
}