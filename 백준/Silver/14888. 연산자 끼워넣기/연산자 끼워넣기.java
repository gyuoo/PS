import java.io.*;
import java.util.*;

public class Main {
    static int N, min, max;
    static int[] numArr, symbolArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        numArr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) numArr[i] = Integer.parseInt(st.nextToken());
        symbolArr = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) symbolArr[i] = Integer.parseInt(st.nextToken());
        int idx = 0;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        choice(1, numArr[0]);
        sb.append(max).append('\n').append(min);
        System.out.println(sb);
    }
    
    static void choice(int idx, int num) {
        if (idx == N) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (symbolArr[i] > 0) {
                symbolArr[i]--;
                calculate(idx, i, num);
                symbolArr[i]++;
            }
        }

    }
    
    static void calculate(int idx, int symbol, int num) {
        if (symbol == 0) choice(idx+1, add(idx, num));
        else if (symbol == 1) choice(idx+1, sub(idx, num));
        else if (symbol == 2) choice(idx+1, mul(idx, num));
        else if (symbol == 3) choice(idx+1, div(idx, num));
    }
    
    static int add (int idx, int num) {
        return num+numArr[idx];
    }
    
    static int sub (int idx, int num) {
        return num-numArr[idx];
    }
    
    static int mul (int idx, int num) {
        return num*numArr[idx];
    }
    
    static int div (int idx, int num) {
        if (num < 0) {
            num *= -1;
            num /= numArr[idx];
            return num*(-1);
        }
        return num/numArr[idx];
    }
}