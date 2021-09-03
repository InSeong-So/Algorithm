# 체크

N = int(input())
houses = [[0, 0, 0]]
for _ in range(N):   
  r, g, b = map(int, input().split())
  houses.append([r, g, b])

dp = [[0 for _ in range(3)] for _ in range(N+1)]

for i in range(1, N+1):
  dp[i][0] = min(dp[i-1][1], dp[i-1][2]) + houses[i][0]
  dp[i][1] = min(dp[i-1][0], dp[i-1][2]) + houses[i][1]
  dp[i][2] = min(dp[i-1][0], dp[i-1][1]) + houses[i][2]

print(min(dp[N]))