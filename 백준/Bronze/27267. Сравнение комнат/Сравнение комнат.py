a, b, c, d = map(int, input().split())
ans = 'E'
if a*b > c*d: ans = 'M'
elif a*b < c*d: ans = 'P'
print(ans)