input()
ans = 0
for i, val in enumerate(reversed(input().split())):
    ans = max(ans, int(val)-i)
print(ans-1)