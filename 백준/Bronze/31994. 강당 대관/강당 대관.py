max = 0
name = ""
for _ in range(7):
    val, num = input().split()
    if max < int(num):
        max = int(num)
        name = val
print(name)