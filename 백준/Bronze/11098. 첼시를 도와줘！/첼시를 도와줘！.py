n = int(input())
for _ in range(n):
    p = int(input())
    max_val = 0
    max_name = ""
    for _ in range(p):
        val, name = input().split()
        val = int(val)
        if (val > max_val):
            max_val = val
            max_name = name
    print(max_name)