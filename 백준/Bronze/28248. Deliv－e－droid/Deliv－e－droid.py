P, C = int(input()), int(input())
score = P*50-C*10
print(score+500 if P > C else score)