N = int(input())
li = [0 for _ in range(N)]
for i in range(N):
    a, d, g = map(int, input().split())
    li[i] = a*(d+g)
    if a == d+g: li[i] += a*(d+g)
print(max(li))