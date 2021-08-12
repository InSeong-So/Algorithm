# 그리디
def is_palindrome(s, start, end):
    for i in range((end - start) // 2 + 1):
        if s[start + i] != s[end - i]:
            return False

    return True


def solution(s):
    for answer in range(len(s), 0, -1):  # 문자열 최대 길이에서 하나씩 줄여나갑니다.
        start = 0  # 0에서
        end = answer - 1  # answer 길이까지

        while end < len(s):
            if is_palindrome(s, start, end):  # 팰린드롬인지 확인합니다
                return answer  # 팰린드롬이면 그대로 리턴
            start += 1
            end += 1  # 한 칸씩 순회합니다.

    return 1  # 한 글자일 경우 1을 리턴합니다.


# # Manacher 알고리즘
# def solution(s):
#     r, p = 0, 0

#     S = sum([[s[i], '#'] for i in range(len(s))], ['#'])

#     A = [0] * len(S)

#     for i in range(1, len(S) - 1):
#         if i < r:
#             A[i] = min(A[2 * p - i], r - i)

#         while i + A[i] - 1 >= 0 and i + A[i] + 1 < len(S) and S[i - A[i] - 1] == S[i + A[i] + 1]:
#             A[i] += 1

#         if i + A[i] > r:
#             r = i + A[i]
#             p = i

#     return max(A)


# # 응용
# def solution(s):
#     p = 0

#     for i in range(len(s)):
#         if s[i - p:i + 1] == s[i - p:i + 1][::-1]:
#             p += 1
#         elif i - p > 0 and s[i - p - 1:i + 1] == s[i - p - 1:i + 1][::-1]:
#             p += 2

#     return p
