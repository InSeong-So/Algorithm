package dataStructure.stack;

import java.util.EmptyStackException;

public class Stack {

	private Node top;
	private int size = 0;
	
	private class Node {
		private Object data;
		private Node next;
		
		public Node(Object input) {
			this.data = input;
			this.next = null;
		}
	}
	
	public Object pop() {
		if (top == null) {
			throw new EmptyStackException();
		}
		Object item = top.data;
		top = top.next;
		size--;
		return item;
	}
	
	public void push(Object input) {
		Node newNode = new Node(input);
		newNode.next = top;
		top = newNode;
		size++;
	}
	
	public Object peek() {
		if(top == null) {
			throw new EmptyStackException();
		}
		
		return top.data;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
}
