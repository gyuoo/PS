import java.io.*;
import java.util.*;

public class Main {
    static class Person implements Comparable<Person> {
        int num, cost;
        Person (int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
        @Override
        public int compareTo(Person o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    static int ans;
    static int[] cost;
    static boolean[] visited;
    static PriorityQueue<Person> pq;
    static ArrayList<Integer>[] relation;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        cost = new int[N];
        relation = new ArrayList[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            relation[i] = new ArrayList<>();
        }
        while (M-->0) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken())-1, w = Integer.parseInt(st.nextToken())-1;
            relation[v].add(w);
            relation[w].add(v);
        }
        ans = 0;
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            pq = new PriorityQueue<>();
            pq.offer(new Person(i, cost[i]));
            dfs(i);
            ans += pq.poll().cost;
            if (k < ans) break;
        }
        System.out.print(ans <= k ? ans : "Oh no");
    }
    static void dfs (int start) {
        visited[start] = true;
        for (int i = 0; i < relation[start].size(); i++) {
            int num = relation[start].get(i);
            if (visited[num]) continue;
            pq.offer(new Person(num, cost[num]));
            dfs(num);
        }
    }
}