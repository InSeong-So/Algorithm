def solution(numbers):
    # 파이썬은 string끼리 비교할 때 맨 앞 자리 ascii 코드로 비교한다.
    # '6', '10' 이 두 가지 문자열을 비교하면
    # 6이 1보다 크기 때문에 '6' > '10'이 True로 나온다.
    # 숫자가 무조건 1000 이하라는 제한 사항을 이용하여 문자열을 3배로 늘려 처리할 수 있다.
    # '6' = '666', '2' = '222', '10' = '101010'
    # '666' > '222' > '101'
    # '6210'

    # 1.
    # 단, ['0', '0', '0'] 일 때는 '0'이 아니라 '000'이 나온다.
    # numbers.sort(key=lambda x: str(x) * 3, reverse=True)
    # return ''.join(list(map(str, numbers)))

    # 2.
    # 시간 복잡도가 높다.
    # numbers.sort(key=lambda x: str(x) * 3, reverse=True)
    # return str(int(''.join(list(map(str, numbers)))))

    # 3.
    # 가지치기를 넣어서 해결한다.
    if len(numbers) == numbers.count(0):
        return '0'

    numbers.sort(key=lambda x: str(x) * 3, reverse=True)
    return ''.join(list(map(str, numbers)))