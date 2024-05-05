import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int ans = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0; i < A.length; i++)
            if (A[ans] < B[i]) ans++;
        return ans;
    }
}