ans = 0
for i in range(1, int(input())+1):
    if i%2 == 0: ans -= 2
    else: ans += 3
print(ans)