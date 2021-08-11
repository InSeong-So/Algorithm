# 체크
import sys
N = int(input())

LIMIT = 501

A = []
dp = [1] * LIMIT

for _ in range(N):
  A.append(list(map(int, sys.stdin.readline().split())))

A.sort(key=lambda a:a[0])

for i in range(1, N):
  for j in range(i):
    if A[i][1] > A[j][1]:
      dp[i] = max(dp[i], dp[j] + 1)

print(dp)

print(N - max(dp))