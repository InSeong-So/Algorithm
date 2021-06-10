# 자물쇠와 열쇠 사본
def solution(key, lock):
    N = len(lock)
    M = len(key)

    # 자물쇠를 확장시킨다. 열쇠를 구멍 하나에만 맞물리게 끼울 수 있으므로
    # 확장할 크기
    size = (M - 1) * 2 + N

    # 확장 함수
    expanded_lock = expand_lock(lock, N, M, size)  # 확장된 자물쇠

    for _ in range(4):  # 90 * 4이므로 360도 회전이면 4이다.
        for y in range(size - M + 1):   # O(n)
            for x in range(size - M + 1):   # O(n)
                # 검증 함수
                if is_unlock(y, x, key, expanded_lock, N, M):  # O(n)
                    return True

        # 회전 함수
        key = rotate(key)

    return False

# 확장


def expand_lock(lock, N, M, size):
    expanded_lock = [[0] * size for _ in range(size)]
    for y in range(N):
        for x in range(M):
            expanded_lock[y + M - 1][x + M - 1] = lock[y][x]

    return expanded_lock

# 회전
# 정사각형이 회전됨 : 파이썬만 가능
# 컬럼을 row로 눕힌 다음에 각 row 값을 거꾸로 뒤집으면 90도 회전한 결과랑 같다.


def rotate(key):
    # *key : 애스터리스크를 붙이면 unpacking이라고 한다. [], (), {}를 벗겨낸다.
    # [[0,0,0], [1,0,0], [0,1,1]] : key
    # [0,0,0], [1,0,0], [0,1,1] : *key
    # (0, 1, 0), (0, 0, 1), (0, 0, 1) : zip(*key)
    # (0, 1, 0), (1, 0, 0), (1, 0, 0) : reversed(zip(*key))
    # [0, 1, 0], [1, 0, 0], [1, 0, 0] : list(reversed(zip(*key)))
    # [[0, 1, 0], [1, 0, 0], [1, 0, 0]] : [list(reversed(zip(*key)))]
    return [list(reversed(i)) for i in zip(*key)]

# 검증


def is_unlock(y, x, key, lock, N, M):
    # 2차원 리스트 복사 : copy.deepcopy()는 매우매우 느리다.
    _lock = [item[:] for item in lock]
    for _y in range(M):
        for _x in range(M):
            _lock[_y + y][_x + x] += key[_y][_x]

    for _y in range(N):
        for _x in range(N):
            if _lock[_y + M - 1][_x + M - 1] != 1:
                return False

    return True
