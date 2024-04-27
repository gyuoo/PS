import java.util.*;

class Solution {
    String[] words;
    public int solution(String[] words) {
        Arrays.sort(words);
        int N = words.length;
        int[] cnt = new int[N]; // 입력해야 하는 문자 수 저장
        for (int i = 0; i < N-1; i++) {
            String now = words[i], next = words[i+1];
            int len = Math.min(now.length(), next.length());
            int prefixLen = getPrefixLen(now, next, len);
            
            // len == prefixLen : 짧은 문자열이 긴 문자열에 완벽히 포함됨
            // -> 따라서 짧은 문자열만큼 치면 됨
            // len != prefixLen : 짧은 문자열을 구별하기 위해 한 글자를 더 쳐야함
            cnt[i] = Math.max(cnt[i], len == prefixLen ? prefixLen : prefixLen+1);
            
            // 다음 문자열 초기화. 최소 prefixLen+1만큼 쳐야 한다
            cnt[i+1] = prefixLen+1;
        }
        // int ans = 0;
        // for (int i : cnt) ans += i;
        // return ans;
        return Arrays.stream(cnt).sum();
    }
    
    int getPrefixLen(String now, String next, int len) {
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (now.charAt(i) == next.charAt(i)) cnt++;
            else return cnt;
        }
        return cnt;
    }
}