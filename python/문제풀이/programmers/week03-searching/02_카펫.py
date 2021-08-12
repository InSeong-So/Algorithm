from math import sqrt


def solution(brown, red):
    answer = []

    # 전체 카펫의 블록 수
    total = brown + red
    # 가로 x 세로 = 총 카펫 블록이므로 전체 카펫의 약수를 구함
    divisors = [i for i in range(1, total+1) if total % i == 0]
    # 빨간 블록의 약수를 구함
    red_divisors = [i for i in range(1, red+1) if red % i == 0]
    red_values = []
    for (y, x) in zip(red_divisors, reversed(red_divisors)):
        if x <= y:
            red_values.append([x, y])

    for (y, x) in zip(divisors, reversed(divisors)):
        if y < 3:
            continue
        if y > x:
            break

        for item in red_values:
            if item[0] == y - 2 and item[1] == x - 2:
                answer.append(x)
                answer.append(y)

    return answer


# 완전탐색
def solution(brown, red):
    width = (brown + red) // 3
    height = 3

    while (width - 2) * (height - 2) != red:
        width -= 1
        height = (brown + red) // width

    return [width, height]


# 이차방정식
def solution(brown, red):
    perimeter = brown + 4  # 둘레
    # perimeter = 2 * length + 2 * width
    area = brown + red  # 넓이
    # area = length * width

    # length = area / width
    # length = (perimeter - 2 * width) / 2
    # area / width = (perimeter - 2 * width) / 2
    # area = (width * perimeter - 2 * width * width) * 2
    # 2 * area = (width * perimter - 2 * width * width)
    # 2A = WP - 2W^2
    # 2W^2 - WP + 2A = 0 좌변으로 옮기자
    # W^2 - WP/2 + A = 0 계수를 제거하자

    # ax^2 + bx + c = 0
    # x = (-b +- sqrt(b ** 2 - 4ac)) / 2c 근의 공식
    # W = (P/2 +- sqrt(-(P/2) ** 2 - 4A)) / 2

    # length = (perimeter // 2 + sqrt((perimeter // 2) ** 2 - 4 * area)) // 2
    # width = (perimeter // 2 - sqrt((perimeter // 2) ** 2 - 4 * area)) // 2

    b = perimeter // 2
    c = area
    length = (b + sqrt(b ** 2 - 4 * c)) // 2
    width = (b - sqrt(b ** 2 - 4 * c)) // 2

    return [length, width]
