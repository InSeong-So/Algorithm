# 사전순
def solution(s):

    stack = []

    # O(n) 혹은 O(n log n)

    # xyb
    # stack = ["x"]
    # stack = ["x"], "y", x < y // 사전 순 정렬된 문자열이 아니므로 pop
    # stack = ["y"], "b" // b는 y보다 작으므로 append
    # stack = ["yb"] ...


    # 가장/최고 등..: 그리디
    # 그리디는 지난 값을 저장해둔걸 꺼내어 더 찾지 않고 현재 주어진 것들로만 처리한다.
    # 완전탐색/백트래킹은 모든 걸 다 탐색한다.

    for char in s:
        while stack and stack[-1] < char:
            stack.pop()
        stack.append(char)

    return ''.join(stack)