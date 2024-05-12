import java.util.*;

class Solution {
    static class Mineral implements Comparable<Mineral>{
        int diamond, iron, stone, sum;
        Mineral (int diamond, int iron, int stone, int sum) {
            this.diamond = diamond;
            this.iron = iron;
            this.stone = stone;
            this.sum = sum;
        }
        @Override
        public int compareTo(Mineral o) {
            if (this.sum == o.sum) {
                if (this.diamond == o.diamond) {
                    return Integer.compare(o.iron, this.iron);
                }
                return Integer.compare(o.diamond, this.diamond);
            }
            return Integer.compare(o.sum, this.sum);
        }
    }
    public int solution(int[] picks, String[] minerals) {
        int ans = 0, len = minerals.length, canDig = 0;
        for (int i : picks) canDig += i*5;
        Mineral[] arr = new Mineral[len%5 == 0 ? len/5 : len/5+1];
        if (canDig < len) arr = new Mineral[canDig/5];
        Mineral m = new Mineral(0, 0, 0, 0);
        for (int i = 0; i < Math.min(canDig, len); i++) {
            if (minerals[i].equals("diamond")) {
                m.diamond++;
                m.sum += 25;
            } else if (minerals[i].equals("iron")) {
                m.iron++;
                m.sum += 5;
            } else {
                m.stone++;
                m.sum++;
            }
            if ((i+1)%5 == 0 || i == len-1) {
                arr[i/5] = m;
                m = new Mineral(0, 0, 0, 0);
            }
        }        
        Arrays.sort(arr);
        for (Mineral mineral : arr) {
            if (0 < picks[0]) {
                picks[0]--;
                ans += mineral.diamond+mineral.iron+mineral.stone;
            } else if (0 < picks[1]) {
                picks[1]--;
                ans += mineral.diamond*5+mineral.iron+mineral.stone;
            } else if (0 < picks[2]) {
                picks[2]--;
                ans += mineral.sum;
            }
        }
        return ans;
    }
}