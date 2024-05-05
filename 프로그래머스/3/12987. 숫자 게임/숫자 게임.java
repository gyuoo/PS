import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int len = A.length, ans = 0, j = len-1;
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = len-1; i >= 0; i--) {
            if (A[i] < B[j]) {
                ans++;
                j--;
            }
        }
        return ans;
    }
}