import sys

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


# Solve 함수
def solution(nums, question):

    dp = [[-1 for _ in range(2000)] for _ in range(2000)]

    def DFS(s, e):
        # 재귀 끝
        if e < s:
            return 1
        # 판별이 된 항목이라면
        if dp[s][e] != -1:
            return dp[s][e]
        # 인덱스가 동일하므로 무조건 팰린드롬
        if s == e:
            dp[s][e] = 1
            return dp[s][e]

        # 시작과 끝 원소가 다르다면 팰린드롬이 아니므로
        if nums[s] != nums[e]:
            dp[s][e] = 0
            return dp[s][e]
        # 같다면? 이제 범위를 줄여가며 체크해야 하므로 재귀실행
        else:
            dp[s][e] = DFS(s + 1, e - 1)
            return dp[s][e]

    for q in question:
        s, e = q
        print(DFS(s - 1, e - 1))

    # for i in range(len(nums)):
    #     for j in range(len(nums)):
    #         print(dp[i][j], end=" ")
    #     print()

    return 1

# # 입력
# input()
# int(input())
# list(map(int, sys.stdin.readline().split()))
# solution()


def test_01(capfd):
    nums = [1, 2, 1, 3, 1, 2, 1]
    question = [
        [1, 3],
        [2, 5],
        [3, 3],
        [5, 7],
    ]
    # solution(nums, question)
    # out, err = capfd.readouterr()
    # result = '1\n0\n1\n1\n'
    # assert out == result
    assert solution(nums, question) == 0


# def test_02(capfd):
    # solution()
    # out, err = capfd.readouterr()
    # result = '\n'
    # assert out == result


# def test_03(capfd):
    # solution()
    # out, err = capfd.readouterr()
    # result = '\n'
    # assert out == result


# def test_04(capfd):
    # solution()
    # out, err = capfd.readouterr()
    # result = '\n'
    # assert out == result
