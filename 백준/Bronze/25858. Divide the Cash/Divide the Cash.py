n, d = map(int, input().split())
li = [int(input()) for _ in range(n)]
val = d//sum(li)
for i in li:
    print(val*i)