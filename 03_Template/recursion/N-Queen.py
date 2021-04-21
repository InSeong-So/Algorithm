# 체스판의 크기
N: int = 8
# 퀸의 위치를 저장할 배열 선언 / 초기화
cols = [0] * (N + 1)


def queens(level: int):
    # 이미 퀸이 존재하거나, 퀸의 경로가 있는지 검증한다.
    if not promising(level):
        return False
    # 체스판의 크기와 동일한 단계에 도달하면 완료!
    elif N == level:
        for i in range(1, N + 1):
            print(i, end="")
            print(",", end="")
            print(cols[i])
        return True
    else:
        # 일단 퀸을 둘 수 있는 상황으로, 배열에 해당 위치를 저장하고 단계를 증가시켜 재귀한다.
        for i in range(1, N + 1):
            # 해당 단계의 퀸 위치 저장한다.
            cols[level + 1] = i
            # 단계를 증가한 뒤 재귀한다.
            if(queens(level + 1)):
                return True
        # False가 반환되는 경우는 promising-검증에서 걸렸을 때이다.
        return False


def promising(level: int):
    # 단계만큼 순회한다.
    for i in range(1, level):
        # 퀸의 위치가 저장된 배열에 해당 단계의 퀸 위치가 존재하면 중지한다.
        if cols[i] == cols[level]:
            return False
        # 퀸의 대각선 경로 검증 : 해당 단계의 퀸을 기준으로 북서, 북동, 남서, 남동쪽을 확인한다.
        elif level - i == abs(cols[level] - cols[i]):
            return False
    # 검증 단계에서 통과한다면 퀸을 배치할 수 있다.
    return True


queens(0)
