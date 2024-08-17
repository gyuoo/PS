str = input()
print('CE' if str[0] != '"' or str[-1] != '"' or len(str) < 3 else str[1:-1])