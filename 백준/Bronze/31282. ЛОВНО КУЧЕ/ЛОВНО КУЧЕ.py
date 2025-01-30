N, M, K = map(int, input().split())
loc, ans = 0, 0
while loc < N:
    loc += K
    N += M
    ans += 1
print(ans)