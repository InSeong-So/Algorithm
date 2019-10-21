package dataStructure.graph;

import java.util.Stack;

import dataStructure.queue.Queue;

public class DFS_BFS {

	class Node {
		int data;
		java.util.LinkedList<Node> testDfs;
		boolean checked;

		Node(int data) {
			this.data = data;
			this.checked = false;
			testDfs = new java.util.LinkedList<Node>();
		}
	}

	Node[] nodes;

	DFS_BFS(int size) {
		nodes = new Node[size];
		for (int i = 0; i < size; i++) {
			nodes[i] = new Node(i);
		}
	}

	void addEdge(int i, int k) {
		Node n1 = nodes[i];
		Node n2 = nodes[k];
		if (!n1.testDfs.contains(n2)) {
			n1.testDfs.add(n2);
		} else if (!n2.testDfs.contains(n1)) {
			n2.testDfs.add(n1);
		}
	}

	void dfs() {
		dfs(0);
	}

	void dfs(int index) {
		Node root = nodes[index];
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		root.checked = true;
		while (!stack.isEmpty()) {
			Node r = stack.pop();
			for (Node n : r.testDfs) {
				if (n.checked == false) {
					n.checked = true;
					stack.push(n);
				}
			}
			visit(r);
		}
	}

	void bfs() {
		bfs(0);
	}

	void bfs(int index) {
		Node root = nodes[index];
		Queue<Node> queue = new Queue<Node>();
		queue.add(root);
		root.checked = true;
		while (!queue.isEmpty()) {
			Node r = queue.remove();
			for (Node n : r.testDfs) {
				if (n.checked == false) {
					n.checked = true;
					queue.add(n);
				}
			}
			visit(r);
		}
	}

	void dfsR(Node r) {
		if (r == null)
			return;
		r.checked = true;
		visit(r);
		for (Node n : r.testDfs) {
			if (n.checked == false) {
				dfsR(n);
			}
		}
	}

	void dfsR(int index) {
		Node r = nodes[index];
		dfsR(r);
	}

	void dfsR() {
		dfs(0);
	}

	void visit(Node n) {
		System.out.println(n.data + " ");
	}
}
