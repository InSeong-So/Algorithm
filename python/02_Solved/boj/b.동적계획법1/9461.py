# 파도반 수열
# a(n) = a(n - 5) + a(n - 1)

import sys

def input_read():
  return int(input())

N = int(input())

dp = [float('inf')] * (100 + 1)

dp[1] = 1
dp[2] = 1
dp[3] = 1
dp[4] = 2
dp[5] = 2

for _ in range(N):
  T = input_read()
  for i in range(6, T + 1):
    if dp[i] == float('inf'):
      dp[i] = dp[i - 5] + dp[i - 1]
  print(dp[T])