while 1:
    N = list(map(int, input()))
    if N[0] == 0: break
    ans = len(N)+1
    for i in N:
        if i == 0: ans += 4
        elif i == 1: ans += 2
        else: ans += 3
    print(ans)