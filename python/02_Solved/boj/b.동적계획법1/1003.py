# 메모이제이션

N = int(input())

result = []

for _ in range(N):
    T = int(input())
    dp = [[1, 0], [0, 1], [1, 1], [1, 2]] + [[0, 0] for _ in range(T-3)]
    for i in range(4, T+1):
        dp[i][0] = dp[i - 1][1]
        dp[i][1] = sum(dp[i - 1])
    
    result.append(f'{dp[T][0]} {dp[T][1]}')

for i in result:
    print(i)