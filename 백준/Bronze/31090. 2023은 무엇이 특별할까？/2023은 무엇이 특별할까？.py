for _ in range(int(input())):
    year = input()
    num = int(year[2:])
    ans = ''
    if (int(year)+1)%num == 0: ans = 'Good'
    else: ans = 'Bye'
    print(ans)