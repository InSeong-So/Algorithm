import sys

input()

numbers = [0] + list(map(int, sys.stdin.readline().split()))

if len(numbers) == 2:
  print(numbers[1])
  exit()

dp = [-1001] * len(numbers)

dp[1] = numbers[1]
dp[2] = max(numbers[1] + numbers[2], numbers[2])

for i in range(3, len(numbers)):
  dp[i] = max(dp[i - 1] + numbers[i], numbers[i])

print(max(dp))