L = int(input())
S = sorted(list(map(int, input().split())))
n = int(input())
ans = 0
if n not in S:
    min_idx = 0
    max_idx = 0
    for i in S:
        if i < n: min_idx = i
        elif n < i and max_idx == 0: max_idx = i
    min_idx += 1
    max_idx -= 1
    ans = (n-min_idx)*(max_idx-n+1)+max_idx-n
print(ans)