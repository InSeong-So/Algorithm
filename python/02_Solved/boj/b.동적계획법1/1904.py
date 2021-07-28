import sys

def input_read():
    return int(input())

N = input_read()

if N == 1:
  print(1)
else:
  dp = [0] * (N + 1)
  dp[0] = 1
  dp[1] = 1
  dp[2] = 2


  for i in range(3, len(dp)):
    dp[i] = (dp[i - 1] + dp[i - 2]) % 15746

  print(dp[N])
