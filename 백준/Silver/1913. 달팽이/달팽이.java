import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine()), N2 = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N], dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int block = 1, blockCnt = 0, dirCnt = 0, moveCnt = 0;
        int[] now = {N/2, N/2};
        arr[N/2][N/2] = 1;
        for (int i = 1; i < N*N; i++) {
            int nr = now[0]+dir[dirCnt%4][0], nc = now[1]+dir[dirCnt%4][1];
            arr[nr][nc] = arr[now[0]][now[1]]+1;
            now[0] = nr;
            now[1] = nc;
            moveCnt++;
            if (moveCnt == block) {
                moveCnt = 0;
                dirCnt++;
                blockCnt++;
            }
            if (blockCnt == 2) {
                blockCnt = 0;
                block++;
            }
        }
        int[] node = new int[2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == N2) {
                    node[0] = i;
                    node[1] = j;
                }
                sb.append(arr[i][j]).append(' ');
            }
            sb.append('\n');
        }
        sb.append(node[0]+1).append(' ').append(node[1]+1);
        System.out.println(sb);
    }
}