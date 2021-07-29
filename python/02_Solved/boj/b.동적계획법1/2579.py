# 체크, 점화식 세우기
N = int(input())

stairs = [0 for _ in range(301)]

for i in range(1, N + 1):
  stairs[i] = int(input())

dp = [0 for _ in range(301)]

dp[1] = stairs[1]
dp[2] = max(stairs[2], stairs[1] + stairs[2])
# dp[3] = max(stairs[1] + stairs[3], stairs[2] + stairs[3])

for i in range(3, N + 1):
  dp[i] = max(dp[i - 3] + stairs[i -1] + stairs[i], dp[i - 2] + stairs[i])

print(dp[N])