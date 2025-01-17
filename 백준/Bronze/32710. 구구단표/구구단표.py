li = []
for i in range(10):
    for j in range(10):
        li.append(i*j)
print(1 if int(input()) in li else 0)