import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int location, move;
        Node (int location, int move) {
            this.location = location;
            this.move = move;
        }
    }
    static int[] ladder, snake;
    static boolean[] visited;
    static ArrayList<Integer> al;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        ladder = new int[101];
        snake = new int[101];
        visited = new boolean[101];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ladder[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            snake[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        al = new ArrayList<>();
        bfs();
        Collections.sort(al);
        System.out.print(al.get(0));
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(1, 0));
        visited[1] = true;
        while (!q.isEmpty()) {
            Node now = q.poll();
            for (int i = 1; i <= 6; i++) {
                int loc = now.location+i;
                if (100 <= loc) {
                    al.add(now.move+1);
                    break;
                }
                if (visited[loc]) continue;
                visited[loc] = true;
                if (ladder[loc] != 0) {
                    visited[ladder[loc]] = true;
                    q.offer(new Node(ladder[loc], now.move+1));
                } else if (snake[loc] != 0) {
                    visited[snake[loc]] = true;
                    q.offer(new Node(snake[loc], now.move+1));
                } else {
                    q.offer(new Node(loc, now.move+1));
                }
            }
        }
    }
}