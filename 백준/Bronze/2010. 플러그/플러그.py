import sys
input = sys.stdin.readline

N, sum = int(input()), 1
for _ in range(N) :
    sum += int(input())
print(sum-N)