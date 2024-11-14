for _ in range(int(input())):
    li = list(input().split())
    rev = []
    for word in li:
        rev.append(word[::-1])
    print(*rev)