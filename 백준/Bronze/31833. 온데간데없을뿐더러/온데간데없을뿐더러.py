int(input())
A, B = int("".join(input().split())), int("".join(input().split()))
print(A if A < B else B)