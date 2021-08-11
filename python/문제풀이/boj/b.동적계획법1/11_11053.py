import sys
N = int(input())
nums = list(map(int,sys.stdin.readline().split()))
dp = [1]*(N)

for i in range(1, N):
  for j in range(i):
    if nums[j] < nums[i]:
      dp[i] = max(dp[i], dp[j]+1)

print(max(dp))