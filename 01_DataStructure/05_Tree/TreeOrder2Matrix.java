/**
 *
 * 이차원 배열로 구현한 트리의 전위, 중위, 후위 순회 결과 출력 프로그램
 * 2차원 배열 [x][0] -> 노드x의 왼쪽 자식
 *           [x][1] -> 노드x의 오른쪽 자식값을 저장하는 방식으로 트리 입력 받음
 * 입력 : 첫 번째 줄에 트리의 노드 개수 n이 주어진다. ( 1 ≤ n ≤ 100 )
 *       두 번째 줄부터 트리의 정보가 주어진다.
 *       각 줄은 3개의 숫자 a, b, c로 이루어지며,
 *       그 의미는 노드 a의 왼쪽 자식노드가 b, 오른쪽 자식노드가 c라는 뜻이다.
 *       자식노드가 존재하지 않을 경우에는 -1이 주어진다.
 * 출력 : 첫째 줄에 전위, 둘째 줄에 중위, 셋째 줄에 후위순회의 결과를 출력한다.
 * 예제 :
 *       6
 *       0 1 2
 *       1 3 4
 *       2 -1 5
 *       3 -1 -1
 *       4 -1 -1
 *       5 -1 -1

       0
      / \
     1   2
    / \   \
   3   4   5
 *
 */
import java.util.*;

public class TreeOrder2Matrix {
	static int n;
	static int[][] tree;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		// tree 저장을 위한 2차원 배열
		for (int i = 0; i < n; i++) {
			tree = new int[n][2];
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			tree[a][0] = b;// 0은 left
			tree[a][1] = c;// 1은 right
		}

		System.out.println("전위 순회");
		preOrder(0);

		System.out.println("\n중위 순회");
		inOrder(0);

		System.out.println("\n후위 순회");
		postOrder(0);
	}

	// 전위순회 Preorder : Root -> Left -> Right
	public static void preOrder(int x) {
		// 왼쪽 자식이나 오른쪽 자식이 없다면 (-1이라면) 순회X
		if (tree[x][0] == -1 && tree[x][1] == -1) {
			System.out.print(x + " ");
		} else {
			System.out.print(x + " ");
			if (tree[x][0] != -1) {
				preOrder(tree[x][0]);
			}
			if (tree[x][1] != -1) {
				preOrder(tree[x][1]);
			}
		}
	}

	// 중위 순회 Inorder : Left -> Root -> Right
	public static void inOrder(int x) {
		if (tree[x][0] == -1 && tree[x][1] == -1) {
			System.out.print(x + " ");
		} else {
			if (tree[x][0] != -1) {
				inOrder(tree[x][0]);
			}
			System.out.print(x + " ");
			if (tree[x][1] != -1) {
				inOrder(tree[x][1]);
			}
		}
	}

	// 후위순회 Postorder : Left -> Right -> Rootpublic
	public static void postOrder(int x) {
		if (tree[x][0] == -1 && tree[x][1] == -1) {
			System.out.print(x + " ");
		} else {
			if (tree[x][0] != -1) {
				postOrder(tree[x][0]);
			}
			if (tree[x][1] != -1) {
				postOrder(tree[x][1]);
			}
			System.out.print(x + " ");
		}
	}
}