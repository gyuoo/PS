n = int(input())
dp = [1 for i in range(n+1)]
for i in range(2, n+1):
    dp[i] = (dp[i-2]+dp[i-1]+dp[i])%1000000007
print(dp[n])