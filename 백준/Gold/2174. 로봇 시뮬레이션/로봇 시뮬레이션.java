import java.io.*;
import java.util.*;

public class Main {
    static int A, B, number;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static char[] state = {'N', 'E', 'S', 'W'};
    static int[][] numArr;
    static char[][] stateArr;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken())+1;
        B = Integer.parseInt(st.nextToken())+1;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        numArr = new int[B][A];
        stateArr = new char[B][A];
        for (int i = 0; i < B; i++) {
            Arrays.fill(stateArr[i], 'o');
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            numArr[B-y][x] = i;
            stateArr[B-y][x] = st.nextToken().charAt(0);

        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            number = Integer.parseInt(st.nextToken());
            char command = st.nextToken().charAt(0);
            int repeat = Integer.parseInt(st.nextToken());
            loop:
            for (int y = 1; y < B; y++) {
                for (int x = 1; x < A; x++) {
                    if (numArr[y][x] == number) {
                        action(y, x, stateArr[y][x], repeat, command);
                        break loop;
                    }
                }
            }
        }
        System.out.println("OK");
    }
    static void action(int y, int x, char c, int repeat, char command) {
        if (command == 'L') {
            left(y, x, c, repeat);
        }
        else if (command == 'R') {
            right(y, x, c, repeat);
        }
        else {
            forward(y, x, 0, repeat);
        }
    }
    static void left(int y, int x, char c, int repeat) {
        for (int i = 0; i < 4; i++) {
            if (c == state[i]) {
                stateArr[y][x] = state[(i+3*repeat)%4];
            }
        }
    }
    static void right(int y, int x, char c, int repeat) {
        for (int i = 0; i < 4; i++) {
            if (c == state[i]) {
                stateArr[y][x] = state[(i+5*repeat)%4];
            }
        }
    }
    static void forward(int y, int x, int count, int repeat) {
        int ny = 0, nx = 0;
        if (count == repeat) return;
        for (int i = 0; i < 4; i++) {
            if (stateArr[y][x] == state[i]) {
                ny = y+dir[i][0];
                nx = x+dir[i][1];
                if (isInRange(ny, nx)) {
                    if (numArr[ny][nx] == 0) {
                        move(y, x, ny, nx);
                    }
                    else {
                        printCrashRobot(numArr[ny][nx]);
                    }
                }
                else {
                    printCrashWall();
                }
            }
        }
        forward(ny, nx, count+1, repeat);
    }
    static void move(int y, int x, int ny, int nx) {
        int temp = numArr[y][x];
        numArr[y][x] = 0;
        numArr[ny][nx] = temp;
        char temp2 = stateArr[y][x];
        stateArr[y][x] = 'o';
        stateArr[ny][nx] = temp2;
    }
    static boolean isInRange(int y, int x) {
        return 1 <= y && y < B && 1 <= x && x < A;
    }
    static void printCrashWall() {
        sb = new StringBuilder();
        sb.append("Robot ").append(number).append(" crashes into the wall");
        System.out.println(sb);
        System.exit(0);
    }
    static void printCrashRobot(int number2) {
        sb = new StringBuilder();
        sb.append("Robot ").append(number).append(" crashes into robot ").append(number2);
        System.out.println(sb);
        System.exit(0);
    }
}