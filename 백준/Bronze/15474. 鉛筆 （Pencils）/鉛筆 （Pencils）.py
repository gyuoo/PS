N, A, B, C, D = map(int, input().split())
X = N//A
if N%A != 0: X += 1
Y = N//C
if N%C != 0: Y += 1
print(min(X*B, Y*D))