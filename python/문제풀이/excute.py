import sys
sys.setrecursionlimit(10**6)

# * ========================================================
# * @Title       : 10942_팰린드롬
# * @Path        : python\문제풀이\boj\z.분류별\10942_팰린드롬.py
# * @Link        : https://www.acmicpc.net/problem/10942_팰린드롬
# * @Description :
# * @Note        :
# * @Date        : 2021-08-14 10:56:08
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================

dp = [[-1 for _ in range(2001)] for _ in range(2001)]


def DFS(start, end):
    # 만약 종료가 시작보다 크다면
    if end < start:
        return 1
    # 만약 체크가 된 팰린드롬이라면
    if dp[start][end] != -1:
        return dp[start][end]
    # 만약 원소가 동일하다면
    if start == end:
        dp[start][end] = 1
        return 1
    # == 여기까진 가지치기
    # 여기서 팰린드롬 체크
    if nums[start] != nums[end]:
        dp[start][end] = 0
        return 0
    else:
        dp[start][end] = DFS(start + 1, end - 1)
        return dp[start][end]


# 입력
input()
nums = list(map(int, sys.stdin.readline().split()))
N = int(sys.stdin.readline().rstrip())
for _ in range(N):
    start, end = map(int, sys.stdin.readline().rstrip().split())
    print(DFS(start-1, end-1))
