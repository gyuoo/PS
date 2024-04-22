a = input()
b = []
for _ in a:
    b.append(a)
    a = a[1:]
for _ in sorted(b): print(_)