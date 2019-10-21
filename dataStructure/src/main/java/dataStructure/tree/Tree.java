package dataStructure.tree;

/*
		(1)
	  /	    \
	(2)		(3)
  /     \
(4)		(5)
Inorder (Left, Root, Right) : 4, 2, 5, 1, 3
Preorder (Root, Left, Right) : 1, 2, 4, 5, 3
Postorder (Left, Right, Root) : 4, 5, 2, 3, 1;			
 */

class Node {
	int data;
	Node left;
	Node right;
}


public class Tree {

	public Node root;

	public void setRoot(Node node) {
		this.root = node;
	}

	public Node getRoot() {
		return root;
	}

	public Node makeNode(Node left, int data, Node right) {
		Node node = new Node();
		node.data = data;
		node.left = left;
		node.right = right;
		return node;
	}

	public void inorder(Node node) {
		if (node != null) {
			inorder(node.left);
			System.out.println(node.data);
			inorder(node.right);
		}
	}

	public void preorder(Node node) {
		if (node != null) {
			System.out.println(node.data);
			preorder(node.left);
			preorder(node.right);
		}
	}

	public void postorder(Node node) {
		if (node != null) {
			postorder(node.left);
			postorder(node.right);
			System.out.println(node.data);
		}
	}
}
