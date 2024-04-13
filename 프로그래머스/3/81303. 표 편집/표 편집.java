import java.util.*;

class Node {
    int prev, num, next;
    Node (int prev, int num, int next) {
        this.prev = prev;
        this.num = num;
        this.next = next;
    }
}

class Solution {
    public StringBuilder solution(int n, int k, String[] cmd) {
        // n: 표의 행 개수, k: 처음 선택된 행의 위치, cmd: 명령어가 담긴 배열
        // 존재 여부를 O, X로 표현하여 문자열 형태로 return
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int cursor = k;
        int[] prev = new int[n], next = new int[n];
        boolean[] removed = new boolean[n];
        Stack<Node> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            prev[i] = i-1;
            next[i] = i+1;
        }
        next[n-1] = -1;
        for (int i = 0; i < cmd.length; i++) {
            st = new StringTokenizer(cmd[i]);
            char c = st.nextToken().charAt(0);
            if (c == 'U') {
                int num = Integer.parseInt(st.nextToken());
                while (num-->0) cursor = prev[cursor];
            }
            else if (c == 'D') {
                int num = Integer.parseInt(st.nextToken());
                while (num-->0) cursor = next[cursor];
            }
            else if (c == 'C') {
                // todo: 현재 선택된 행 삭제
                stack.push(new Node(prev[cursor], cursor, next[cursor]));
                if (next[cursor] != -1) prev[next[cursor]] = prev[cursor];
                if (prev[cursor] != -1) next[prev[cursor]] = next[cursor];
                removed[cursor] = true;
                // 삭제된 행이 endIdx인 경우 바로 윗 행 선택
                if (next[cursor] == -1) cursor = prev[cursor];
                // 삭제한 아래 행 선택
                else cursor = next[cursor];
            }
            else {
                // 가장 최근 삭제된 행을 복구, 단 현재 선택된 행(cursor)은 바뀌지 않음
                Node node = stack.pop();
                // 현재 n.prev의 next는 n.num
                // 현재 n.next의 prev는 n.num
                removed[node.num] = false;
                if (node.next != -1) prev[node.next] = node.num;
                if (node.prev != -1) next[node.prev] = node.num;
            }
        }
        for (boolean b : removed) sb.append(!b ? 'O' : 'X');
        return sb;
    }
}