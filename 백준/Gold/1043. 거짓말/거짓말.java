import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int truth = Integer.parseInt(st.nextToken());
        HashSet<Integer> truths = new HashSet<>();
        for (int i = 0; i < truth; i++) truths.add(Integer.parseInt(st.nextToken()));
        ArrayList<Integer>[] parties = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            parties[i] = new ArrayList<>();
            int size = Integer.parseInt(st.nextToken());
            for (int j = 0; j < size; j++) {
                parties[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        parent = new int[N+1];
        for (int i = 1; i <= N; i++) parent[i] = i;
        for (ArrayList<Integer> party : parties) {
            for (int i = 1; i < party.size(); i++) {
                union(party.get(0), party.get(i));
            }
        }
        HashSet<Integer> truthParents = new HashSet<>();
        for (int i : truths) truthParents.add(find(i));
        int ans = 0;
        for (ArrayList<Integer> party : parties) {
            boolean canLie = true;
            for (int i : party) {
                if (truthParents.contains(find(i))) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) ans++;
        }
        System.out.print(ans);
    }
    static int find(int n) {
        if (parent[n] != n) parent[n] = find(parent[n]);
        return parent[n];
    }
    static void union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa != pb) parent[pa] = pb;
    }
}