N = int(input())
ans = 0
for i in range(2, N-1, 2):
    ans += (N-i-2)//2
print(ans)