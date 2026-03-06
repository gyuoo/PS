import java.util.*;

class Solution {

    static class WordInfo {
        String word;
        int revealAt;   // 몇 번째 spoiler range 클릭 후 완전 공개되는지
        boolean spoiler;

        WordInfo(String word, int revealAt, boolean spoiler) {
            this.word = word;
            this.revealAt = revealAt;
            this.spoiler = spoiler;
        }
    }

    public int solution(String message, int[][] spoiler_ranges) {
        int n = message.length();
        int m = spoiler_ranges.length;

        boolean[] covered = new boolean[n];
        int[] revealIdx = new int[n];
        Arrays.fill(revealIdx, -1);

        // 1) 각 문자에 대해 스포 여부 / 몇 번째 range에 속하는지 기록
        for (int i = 0; i < m; i++) {
            int start = spoiler_ranges[i][0];
            int end = spoiler_ranges[i][1];
            for (int j = start; j <= end; j++) {
                covered[j] = true;
                revealIdx[j] = i;
            }
        }

        // 2) 단어 파싱
        Set<String> normalWords = new HashSet<>();
        List<List<String>> revealedAt = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            revealedAt.add(new ArrayList<>());
        }

        int idx = 0;
        while (idx < n) {
            int start = idx;
            while (idx < n && message.charAt(idx) != ' ') {
                idx++;
            }
            int end = idx - 1;

            String word = message.substring(start, idx);

            boolean isSpoilerWord = false;
            int lastReveal = -1;

            for (int i = start; i <= end; i++) {
                if (covered[i]) {
                    isSpoilerWord = true;
                    lastReveal = Math.max(lastReveal, revealIdx[i]);
                }
            }

            if (!isSpoilerWord) {
                normalWords.add(word);
            } else {
                revealedAt.get(lastReveal).add(word);
            }

            idx++; // 공백 넘기기
        }

        // 3) 공개 순서대로 중요한 단어 판정
        int answer = 0;
        Set<String> revealedSpoilerWords = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (String word : revealedAt.get(i)) {
                if (!normalWords.contains(word) && !revealedSpoilerWords.contains(word)) {
                    answer++;
                }
                // 중요 여부와 상관없이 "공개된 스포 단어"로 기록
                revealedSpoilerWords.add(word);
            }
        }

        return answer;
    }
}