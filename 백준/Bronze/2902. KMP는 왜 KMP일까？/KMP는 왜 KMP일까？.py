ans = ''
for _ in input().split('-'):
    if _[0].isupper():
        ans += _[0]
print(ans)