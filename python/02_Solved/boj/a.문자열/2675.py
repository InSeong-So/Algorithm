N = int(input())

for _ in range(N):
  T = input().split()
  result = ''
  for i in range(len(T[1])):
    result += T[1][i] * int(T[0])
  print(result)
