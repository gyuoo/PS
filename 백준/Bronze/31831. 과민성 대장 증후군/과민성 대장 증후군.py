N, M = map(int, input().split())
A = list(map(int, input().split()))
ans, num = 0, 0
for i in A:
    num += i
    if num < 0: num = 0
    if M <= num: ans += 1
print(ans)