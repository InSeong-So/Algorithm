# 빙고
def solution(board, nums):

    N = len(board)
    nums = set(nums)

    for i in range(N): # O(n)
        for j in range(N): # O(n)
            # 여기서 숫자를 지운다. : 0으로 변경
            if board[i][j] in nums: #O(nums) -> O(n^2 + nums), 이를 해결하기위해 set을 만든다. : O(1)
                board[i][j] = 0
    
    # 빙고 체크를 한다.
    answer += len([i for i in board if sum(i) == 0])    # 가로
    answer += len([i for i in zip(*board) if sum(i) == 0])    # 세로(뒤집어서), unpack한다.
    answer += int(sum(board[i][i] for i in range(N)) == 0) # 대각선
    answer += int(sum(board[N- 1 - i][i] for i in range(N)) == 0) # 대각선

    return answer