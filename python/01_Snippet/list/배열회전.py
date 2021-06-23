# 인자 target 형태(행x렬은 상관없음)
'''
[
    [0,0,0],
    [1,0,0],
    [0,1,1]
]
'''
def rotate(target):
    # *target : 애스터리스크를 붙이면 unpacking이라고 한다. [], (), {}를 벗겨낸다.
    # [[0,0,0], [1,0,0], [0,1,1]] : target
    # [0,0,0], [1,0,0], [0,1,1] : *target
    # (0, 1, 0), (0, 0, 1), (0, 0, 1) : zip(*target)
    # (0, 1, 0), (1, 0, 0), (1, 0, 0) : reversed(zip(*target))
    # [0, 1, 0], [1, 0, 0], [1, 0, 0] : list(reversed(zip(*target)))
    # [[0, 1, 0], [1, 0, 0], [1, 0, 0]] : [list(reversed(zip(*target)))]
    return [list(reversed(i)) for i in zip(*target)]