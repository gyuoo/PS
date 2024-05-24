A, B, C = map(int, input().split())
D = A*B/C
E = A/B*C
print(int(D) if D>E else int(E))