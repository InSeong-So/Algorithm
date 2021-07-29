N = int(input())

triangle = []
dp = [[0 for _ in range(N)] for _ in range(N+1)]
for _ in range(1, N+1):
  triangle.append(list(map(int, input().split())))

for i in range(1, N+1):
  for j in range(i):
    dp[i][j] = max(dp[i-1][j], dp[i-1][j-1]) + triangle[i-1][j]

print(max(dp[N]))