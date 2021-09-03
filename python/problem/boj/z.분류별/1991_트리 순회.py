import sys

# * ========================================================
# * @Title       : 1991
# * @Path        : python\문제풀이\boj\z.분류별\1991_트리 순회.py
# * @Link        : https://www.acmicpc.net/problem/1991
# * @Description : 트리 순회
# * @Note        :
# * @Date        : 2021-08-13 09:34:25
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================


# Solve 함수
def solution(tree):

    # 전위 : 부모-왼쪽-오른쪽
    def preorder(node):
        print(node, end="")
        if tree[node][0] != '.':
            preorder(tree[node][0])
        if tree[node][1] != '.':
            preorder(tree[node][1])

    # 중위 : 왼쪽-부모-오른쪽
    def inorder(node):
        if tree[node][0] != '.':
            inorder(tree[node][0])
        print(node, end="")
        if tree[node][1] != '.':
            inorder(tree[node][1])

    # 후위 : 왼쪽-오른쪽-부모
    def postorder(node):
        if tree[node][0] != '.':
            postorder(tree[node][0])
        if tree[node][1] != '.':
            postorder(tree[node][1])
        print(node, end="")

    preorder('A')
    print()
    inorder('A')
    print()
    postorder('A')


# 입력
# tree = dict()
# for _ in range(int(input())):
#     node, left, right = sys.stdin.readline().split()
#     tree[node] = (left, right)

# solution(tree)


def test_01(capfd):
    N = 7
    pairs = [
        ['A', 'B', 'C'],
        ['B', 'D', '.'],
        ['C', 'E', 'F'],
        ['E', '.', '.'],
        ['F', '.', 'G'],
        ['D', '.', '.'],
        ['G', '.', '.'],
    ]
    tree = dict()
    for node, left, right in pairs:
        tree[node] = (left, right)
    solution(tree)
    out, err = capfd.readouterr()
    result = 'ABDCEFG\nDBAECFG\nDBEGFCA'
    assert out == result


# def test_02(capfd):
    # solution()
    # out, err = capfd.readouterr()
    # result = '\n'
    # assert out == result


# def test_03(capfd):
    # solution()
    # out, err = capfd.readouterr()
    # result = '\n'
    # assert out == result


# def test_04(capfd):
    # solution()
    # out, err = capfd.readouterr()
    # result = '\n'
    # assert out == result
