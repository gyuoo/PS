n = int(input())
list = [int(input()) for _ in range(n)]
dp = [0 for _ in range(n)]
ans = sum(list)
if 3 <= n:
    dp[0] = list[0]
    dp[1] = list[0]+list[1]
    dp[2] = max(list[0]+list[2], list[1]+list[2])
    for i in range(3, n):
        dp[i] = max(dp[i-3]+list[i-1]+list[i], dp[i-2]+list[i])
    ans = dp[n-1]
print(ans)