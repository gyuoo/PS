import sys
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    N = int(input())
    cnt = 0
    val = 5
    while val <= N:
        cnt += N//val
        val *= 5
    print(cnt)