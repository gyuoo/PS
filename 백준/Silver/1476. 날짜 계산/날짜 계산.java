import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int E2 = 0, S2 = 0, M2 = 0, ans = 0;
		while (true) {
			if (E2 == 15) E2 = 0;
			if (S2 == 28) S2 = 0;
			if (M2 == 19) M2 = 0;
			ans++; E2++; S2++; M2++;
			if (E == E2 && S == S2 && M == M2) break;
		}
		System.out.println(ans);
	}
}