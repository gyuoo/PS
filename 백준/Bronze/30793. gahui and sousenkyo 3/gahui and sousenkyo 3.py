p, r = map(int, input().split())
val = p/r
ans = 'weak'
if 0.6 <= val: ans = 'very strong'
elif 0.4 <= val: ans = 'strong'
elif 0.2 <= val: ans = 'normal'
print(ans)