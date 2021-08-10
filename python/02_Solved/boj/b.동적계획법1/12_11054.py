import sys

N = int(input())
bytonic = list(map(int, sys.stdin.readline().split()))

dp1 = [1] * N
dp2 = [1] * N

for i in range(1, N):
    for j in range(i):
        if bytonic[i] > bytonic[j]:
            dp1[i] = max(dp1[i], dp1[j] + 1)

for i in range(N - 2, -1, -1):
    for j in range(N-1, i, -1):
        if bytonic[i] > bytonic[j]:
            dp2[i] = max(dp2[i], dp2[j] + 1)

max = 0

print(dp1)
print(dp2)

for i in range(N):
    result = dp1[i] + dp2[i] - 1
    if max < result:
        max = result

print(max)

# input()
# d = {}
# e = {}
# a = []
# num = list(map(int,input().split()))
# r = 0
# for i in num:
#     s = sum(i>d[k] for k in d)
#     d[s] = i
#     a[:0] = s,
# for i,a in zip(num[::-1], a):
#     s = sum(i > e[k] for k in e)
#     e[s] = i
#     r = max(r,a+s+1)
# print(r)
