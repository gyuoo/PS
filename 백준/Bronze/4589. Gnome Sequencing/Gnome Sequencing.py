print("Gnomes:")
for _ in range(int(input())):
    li = list(map(int, input().split()))
    if sorted(li) == li or sorted(li, reverse = True) == li: print("Ordered")
    else: print("Unordered")