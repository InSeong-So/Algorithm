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

def solution(N):
  # DP 배열
  dp = [[0 for _ in range(10)] for _ in range(N+1)]
  
  # 1의 자릿수 초기화
  for i in range(10):
    dp[1][i] = 1

  # 계단 수 세기
  for i in range(2, N + 1):
    for j in range(10):
      if j >= 1:
        dp[i][j] += dp[i - 1][j - 1]
      if j <= 8:
        dp[i][j] += dp[i - 1][j + 1]

  return sum(dp[N]) - dp[N][0]

def test_01():
  assert solution(1) == 9

def test_02():
  assert solution(2) == 17

def test_03():
  assert solution(3) == 32

def test_04():
  assert solution(4) == 61