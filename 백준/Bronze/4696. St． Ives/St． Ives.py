while 1:
    N = float(input())
    if N == 0: break
    print(format(1+N+N*N+N*N*N+N*N*N*N, ".2f"))