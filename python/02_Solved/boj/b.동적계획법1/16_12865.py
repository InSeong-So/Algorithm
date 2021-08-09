import sys

N, K = map(int, sys.stdin.readline().split())
things = [[0, 0] for _ in range(N+1)]
# 무게 배열
dp = [0] * 100001

for i in range(1, N + 1):
  things[i][0], things[i][1] = map(int, sys.stdin.readline().split())

for w, v in things:
  for i in range(K, w-1, -1):
    dp[i] = max(dp[i], dp[i-w] + v)

print(dp[K])