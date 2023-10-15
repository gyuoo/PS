import sys
input = sys.stdin.readline
while 1:
    s = input().strip()
    if s == '#': break
    cnt = 0
    for c in s:
        if c in 'AEIOUaeiou':
            cnt += 1
    print(cnt)