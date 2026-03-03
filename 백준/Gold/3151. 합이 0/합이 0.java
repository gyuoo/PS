import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        long ans = 0;
        for (int i = 0; i < N-2; i++) {
            int l = i+1, r = N-1;
            while (l < r) {
                int sum = A[i]+A[l]+A[r];
                if (sum < 0) l++;
                else if (sum > 0) r--;
                else {
                    if (A[l] == A[r]) {
                        long k = r-l+1;
                        ans += k*(k-1)/2;
                        break;
                    }
                    int valL = A[l], valR = A[r];
                    long cntL = 0, cntR = 0;
                    while (l < r && A[l] == valL) {
                        cntL++;
                        l++;
                    }
                    while (l <= r && A[r] == valR) {
                        cntR++;
                        r--;
                    }
                    ans += cntL*cntR;
                }
            }
        }
        System.out.print(ans);
    }

}