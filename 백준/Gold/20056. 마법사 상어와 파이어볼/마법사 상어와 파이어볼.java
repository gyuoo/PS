import java.io.*;
import java.util.*;

public class Main {
	static class Fireball {
		int r, c, m, s, d;
		Fireball(int r, int c, int m, int s, int d) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		} 
	}
	static int N, M;
	static ArrayList<Fireball> fireballs;
	static int[][] arr, dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		fireballs = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1, c = Integer.parseInt(st.nextToken())-1;
			fireballs.add(new Fireball(r, c, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			arr[r][c]++;
		}
		for (int k = 0; k < K; k++) {
			for (Fireball fb : fireballs) move(fb, arr);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] >= 2) sum(i, j);
				}
			}
			remove();
		}
		int ans = 0;
		for (Fireball fb : fireballs) ans += fb.m;
		System.out.println(ans);
	}
	
	static void move(Fireball fb, int[][] arr) {
		int nr = fb.r+dir[fb.d][0]*fb.s, nc = fb.c+dir[fb.d][1]*fb.s;
		if (nr < 0) {
			while (nr < 0) nr += N;
		}
		if (nc < 0) {
			while (nc < 0) nc += N;
		}
		nr %= N;
		nc %= N;
		arr[fb.r][fb.c]--;
		arr[nr][nc]++;
		fb.r = nr;
		fb.c = nc;
	}
	
	static void sum(int r, int c) {
		ArrayList<Fireball> al = new ArrayList<>();
		for (int i = 0; i < fireballs.size(); i++) {
			if (r == fireballs.get(i).r && c == fireballs.get(i).c) {
				al.add(fireballs.get(i));
			}
		}
		Fireball first = al.get(0);
		int[] dirArr = new int[al.size()];
		dirArr[0] = al.get(0).d;
		for (int i = 1; i < al.size(); i++) {
			first.m += al.get(i).m;
			first.s += al.get(i).s;
			dirArr[i] = al.get(i).d;
			fireballs.remove(al.get(i));
		}
		separate(first, isAllOddOrEven(dirArr), al.size());
	}
	
	static void separate(Fireball fb, boolean flag, int size) {
		int startDir = flag ? 0 : 1;
		for (int i = 0; i < 4; i++) {
			fireballs.add(new Fireball(fb.r, fb.c, fb.m/5, fb.s/size, startDir+i*2));
		}
		fireballs.remove(fb);
		arr[fb.r][fb.c] = 4; 
	}
	
	static void remove() {
		for (int i = 0; i < fireballs.size(); i++) {
			Fireball now = fireballs.get(i);
			if (now.m == 0) {
				arr[now.r][now.c]--;
				fireballs.remove(i--);
			}
		}
	}
	
	static boolean isAllOddOrEven(int[] arr) {
		int first = arr[0]%2;
		for (int i : arr) {
			if (i%2 != first) return false; 
		}
		return true;
	}
}