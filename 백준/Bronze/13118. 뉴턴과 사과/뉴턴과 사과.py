list = list(map(int, input().split()))
x, y, r = map(int, input().split())
print(list.index(x)+1 if x in list else 0)