/**
 *
 * 클래스로 구현한 이진 트리의 전위, 중위, 후위 순회 결과 출력 프로그램
 * Class 구조체에 노드값, 왼쪽 자식 노드값, 오른쪽 자식 노드값 저장해 구현

   입력 : 첫 번째 줄에 트리의 노드 개수 n이 주어진다. ( 1 ≤ n ≤ 100 )
         두 번째 줄부터 트리의 정보가 주어진다. 각 줄은 3개의 숫자 a, b, c로 이루어지며,
         그 의미는 노드 a의 왼쪽 자식노드가 b, 오른쪽 자식노드가 c라는 뜻이다.
         자식노드가 존재하지 않을 경우에는 -1이 주어진다.
   출력 : 첫 번째 줄에 전위순회, 두 번째 줄에 중위순회, 세 번째 줄에 후위순회 결과를 출력한다.
   예제 :

					6
					0 1 2
					1 3 4
					2 -1 5
					3 -1 -1
					4 -1 -1
					5 -1 -1

			       0
			      / \
			     1   2
			    / \   \
			   3   4   5

 */
import java.util.*;

class Node {// 트리의 노드 정보를 저장할 클래스 구조체
	int data;// 노드 값
	Node left;// 왼쪽 자식 노드 참조 값
	Node right;// 오른쪽 자식 노드 참조 값

	// 추가할 때 참조되는 왼쪽, 오른쪽 자식의 값은 모르닌까 일단 data 값을 기반으로 Node 객체 생성
	Node(int data) {
		this.data = data;
	}
}

public class TreeOrderClass {
	public Node root;// 초기 root는 null

	public void createNode(int data, int leftData, int rightData) {
		if (root == null) {// 초기 상태 - 루트 노드 생성
			root = new Node(data);

			// 좌우 값이 있는 경우, 즉 -1이 아닌 경우 노드 생성
			if (leftData != -1) {
				root.left = new Node(leftData);// 왼쪽 자식 노드 값을 가지는 Node 인스턴스 생성
			}
			if (rightData != -1) {
				root.right = new Node(rightData);// 오른쪽 자식 노드 값을 가지는 Node 인스턴스 생성
			}
		} else {// 초기 상태가 아니라면, 루트 노드 생성 이후 만들어진 노드 중 어떤건지를 찾아야함
			searchNode(root, data, leftData, rightData);
		}
	}

	// 매개변수로 들어온 root노드를 시작으로 data와 같은 값을 가진 node를 찾는다.
	// 찾을 때까지 root노드에서부터 왼쪽, 오른쪽으로 내려감
	public void searchNode(Node node, int data, int leftData, int rightData) {
		if (node == null) {// 도착한 노드가 null이면 재귀 종료 - 찾을(삽입할) 노드 X
			return;
		} else if (node.data == data) {// 들어갈 위치를 찾았다면
			if (leftData != -1) {// -1이 아니라 값이 있는 경우에만 좌우 노드 생성
				node.left = new Node(leftData);
			}
			if (rightData != -1) {
				node.right = new Node(rightData);
			}
		} else {// 아직 찾지못했고 탐색할 노드가 남아 있다면
			searchNode(node.left, data, leftData, rightData);// 왼쪽 재귀 탐색
			searchNode(node.right, data, leftData, rightData);// 오른쪽 재귀 탐색
		}
	}

	// 전위순회 Preorder : Root -> Left -> Right
	public void preOrder(Node node) {
		if (node != null) {
			System.out.print(node.data + " ");
			if (node.left != null)
				preOrder(node.left);
			if (node.right != null)
				preOrder(node.right);
		}
	}

	// 중위 순회 Inorder : Left -> Root -> Right
	public void inOrder(Node node) {
		if (node != null) {
			if (node.left != null)
				inOrder(node.left);
			System.out.print(node.data + " ");
			if (node.right != null)
				inOrder(node.right);
		}
	}

	// 후위순회 Postorder : Left -> Right -> Root
	public void postOrder(Node node) {
		if (node != null) {
			if (node.left != null)
				postOrder(node.left);
			if (node.right != null)
				postOrder(node.right);
			System.out.print(node.data + " ");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Tree t = new Tree();

		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();

			t.createNode(a, b, c);
		}

		System.out.println("전위 순회");
		t.preOrder(t.root);

		System.out.println("\n중위 순회");
		t.inOrder(t.root);

		System.out.println("\n후위 순회");
		t.postOrder(t.root);
	}
}