# 방문 길이
# def solution(dirs):
#     # 시작 위치를 생성
#     x, y = 0, 0

#     # 지나온 곳을 체크
#     check = dict()

#     for command in dirs:
#         if command == 'U' and y < 5:
#             # 위치 저장
#             check[(x, y, x, y+1)] = True
#             # 이동
#             y += 1
#         elif command == 'D' and y > -5:
#             # check[(x, y, x, y-1)] = True # 겹칠 수 있음... 0102 0201 같이
#             check[(x, y-1, x, y)] = True
#             y -= 1
#         elif command == 'R' and x < 5:
#             check[(x, y, x+1, y)] = True
#             x += 1
#         elif command == 'L' and x > -5:
#             check[(x-1, y, x, y)] = True
#             x -= 1

#     return len(check)

# tuple을 이용한 방법
def solution(dirs):
    # y, x
    position = (0, 0)  # Tuple
    command_dict = {
        'U': (-1, 0),
        'D': (1, 0),
        'R': (0, 1),
        'L': (0, -1),
    }

    check = set()
    for command in dirs:
        direction = command_dict[command]
        next_position = (position[0] + direction[0],
                         position[1] + direction[1])
        # next_position = tuple(map(sum, zip(position, direction)))

        y, x = next_position
        # 범위 안에 있으면 체크
        if -5 <= y <= 5 and -5 <= x <= 5:
            check.add(tuple(sorted([position, next_position])))
            position = next_position

    return len(check)
