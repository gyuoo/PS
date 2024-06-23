n, m = map(int, input().split())
s = set()
user = []
for _ in range(n):
    arr = input().split()
    name = arr.pop()
    max_cnt, cnt = 0, 0
    for i in arr:
        if i == '.':
            cnt += 1
        else:
            max_cnt = max(max_cnt, cnt)
            cnt = 0
    max_cnt = max(max_cnt, cnt)
    s.add(max_cnt)
    user.append([max_cnt, name])
print(len(s))
for i in user:
    print(*i)