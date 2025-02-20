t1, m1, t2, m2 = map(int, input().split())
total = (1440-(t1*60+m1)+t2*60+m2)%1440
print(total, total//30)