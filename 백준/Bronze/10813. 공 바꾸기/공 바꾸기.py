import sys
input = sys.stdin.readline

N, M = map(int, input().split())
list = [i+1 for i in range(N)]
for _ in range(M):
    i, j = map(int, input().split())
    list[i-1], list[j-1] = list[j-1], list[i-1]
print(*list)