for _ in range(int(input())):
    M = input()
    cnt = [0 for i in range(26)]
    ans = "OK"
    flag = False
    for i in range(len(M)):
        if flag:
            flag = False
            continue
        cnt[ord(M[i])-ord('A')] += 1
        if cnt[ord(M[i])-ord('A')]%3 == 0:
            if i == len(M)-1 or M[i] != M[i+1]:
                ans = "FAKE"
                break
            flag = True
    print(ans)