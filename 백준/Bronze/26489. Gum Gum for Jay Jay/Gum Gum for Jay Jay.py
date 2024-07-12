ans = 0
while True:
    try:
        input()
        ans += 1
    except EOFError:
        break
print(ans)