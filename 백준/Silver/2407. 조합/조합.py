n, m = map(int, input().split())
min = min(m, n-m)
de, nu = 1, 1
for i in range(min):
    de *= i+1
    nu *= n-i
print(nu//de)