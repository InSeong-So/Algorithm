def solution(strs, t):
    dp = [0] * (len(t) + 1)  # 미리 단어 길이만큼 리스트 생성합니다.

    strs = set(strs)  # 리스트를 set으로 변환합니다.

    for i in range(1, len(t) + 1):  # 편의를 위해 1부터 시작합니다.
        dp[i] = float('inf')  # 처음엔 길이가 무한입니다. (조합이 불가능하다는 의미)
        # 단어 조각의 길이는 5 이하라는 점을 이용하여 루프를 돌립니다.
        for j in range(1, min(i + 1, 6)):
            start = i - j
            end = i
            # 문자열 t의 start부터 end까지 strs에 포함되었는지 체크합니다.
            if t[start:end] in strs:
                # 포함되었다면 현재값과 이전 값+1 중 더 작은 값을 저장합니다.
                dp[i] = min(dp[i], dp[i - j] + 1)

    # 최종 결과가 무한이라면 불가능하다는 뜻이니 -1을 반환합니다.
    return -1 if dp[-1] == float('inf') else dp[-1]
