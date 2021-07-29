N = int(input())

wines = [0] * (10001)
dp = [0] * (10001)

for i in range(1, N+1):
  wines[i] = int(input())

dp[1] = wines[1]
dp[2] = wines[1] + wines[2]

for i in range(3, N+1):
  dp[i] = max(dp[i - 3] + wines[i - 1] + wines[i], dp[i - 2] + wines[i], dp[i - 1])

print(dp[N])