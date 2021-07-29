# 체크
dp = [[0 for _ in range(10)] for _ in range(101)]

# 0의 자리는 1로 초기화한다.
dp[1] = [1, 1, 1, 1, 1, 1, 1, 1, 1, 1]

N = int(input())

for i in range(2, N+1):
  for j in range(10):
    if j >= 1:
      dp[i][j] += dp[i - 1][j - 1]
    if j <= 8:
      dp[i][j] += dp[i - 1][j + 1]

print((sum(dp[N]) - dp[N][0]) %1000000000)