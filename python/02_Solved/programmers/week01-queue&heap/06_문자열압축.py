# 6: 문자열 압축
def solution(s):
    answer = len(s)

    # 문자열의 절반까지 가면 압축이 안될것
    for size in range(1, len(s) // 2 + 1):
        count = 1
        compress = 0

        # 이전값과 다음값 비교
        prev = s[:size]

        for i in range(size, len(s) + size, size):
            curr = s[i:i + size]
            if prev == curr:
                count += 1
            else:
                # inline if
                compress += size + len(str(count)) if 1 < count else len(prev)
                prev = curr
                count = 1

        answer = min(answer, compress)

    return answer
