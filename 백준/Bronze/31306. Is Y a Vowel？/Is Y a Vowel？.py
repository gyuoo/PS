li = ['a', 'e', 'i', 'o', 'u']
a, b = 0, 0
for i in input():
    if i in li: a += 1
    elif i == 'y': b += 1
print(a, a+b)