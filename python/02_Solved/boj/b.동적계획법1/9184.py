import sys
def input_read():
    return list(map(int,sys.stdin.readline().split()))

def w(dp, a, b, c):
  if a <= 0 or b <= 0 or c <= 0:
    return 1
  elif a > 20 or b > 20 or c > 20 :
    return w(dp, 20, 20, 20)
  
  if dp[a][b][c] != float('inf'):
    return dp[a][b][c]

  if a < b and b < c:
    dp[a][b][c] = w(dp, a, b, c-1) + w(dp, a, b-1, c-1) - w(dp, a, b-1, c)
  else:
    dp[a][b][c] = w(dp, a-1, b, c) + w(dp, a-1, b-1, c) + w(dp, a-1, b, c-1) - w(dp, a-1, b-1, c-1)
  return dp[a][b][c]

dp = [[[float('inf') for _ in range(21)] for _ in range(21)] for _ in range(21)]

while True:
  a, b, c = input_read()
  if a == -1 and b == -1 and c == -1:
    break
  print(f'w({a}, {b}, {c}) = {w(dp, a, b, c)}')