while True:
    try: n = int(input())
    except: break
    len = num = 1
    while num%n != 0:
        num = num*10+1
        len += 1
    print(len)