# * ========================================================
# * @Title       : test
# * @Path        : python\02_Solved\boj\f.DFS와BFS\test.py
# * @Description :
# * @Date        : 2021-08-06 11:20:52
# * --------------------------------------------------------
# * @Author      : Inseong-so(https://github.com/inseong-so)
# * ========================================================

# 복습용, 함수화할 부분
def solution():
    print("Hello World!", end="")


def test_01(capfd):
    solution()
    out, err = capfd.readouterr()
    assert out == "Hello World!"


def test_02():
    assert 1 == 1


def test_03():
    assert 1 == 1


def test_04():
    assert 1 == 1
