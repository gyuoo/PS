ans = 0
for i in range(8):
    for j, val in enumerate(input()):
        if (i%2 == 0 and j%2 == 0 and val == 'F') or (i%2 == 1 and j%2 == 1 and val == 'F'):
            ans += 1
print(ans)