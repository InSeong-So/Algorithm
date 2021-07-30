N = [input() for _ in range(2)]


dp = [[1 for _ in range(len(N[1]) + 1)] for _ in range(len(N[0]) + 1)]

for i in range(len(N[0])+1):
    dp[i][0] = 0
for i in range(len(N[1])+1):
    dp[0][i] = 0

for i in range(1, len(N[0]) + 1):
    for j in range(1, len(N[1]) + 1):
        # 증가 카운트
        if N[0][i-1] == N[1][j-1]:
            dp[i][j] = dp[i - 1][j - 1] + 1
        # 자신의 전 단계 값 중 가장 큰 값
        else:
            dp[i][j] = max(dp[i-1][j], dp[i][j-1])

print(max(dp[len(dp) - 1]))