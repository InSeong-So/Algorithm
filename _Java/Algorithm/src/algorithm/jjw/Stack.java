package algorithm.jjw;

import java.util.EmptyStackException;

public class Stack<T> {
	
	
	// 가장마지막에 삽입된 데이터의 위치를 가리는 포인터
	private Node<T> top;
	
	// 스택의 크기
	private int size = 0;
	
	//데이터를 암시하는 클래스
	private class Node<T> {
		
		//데이터
		private T data;
		
		// 다음 데이터를 암시하는 포인터
		private Node<T> next;
		
		// 생성자, 처음 생성 시 스택으 데이터는 하나, 다음 데이터는 존재하지 않음
		public Node(T input) {
			this.data = input;
			this.next = null;
		}
	}
	
	// peek push pop
	public T peek() {
		
		if(top == null)
			throw new EmptyStackException();
		
		return top.data;
	}
	
	public void push(T input) {
		Node<T> newNode = new Node<T>(input);
		
		newNode.next = top;
		top = newNode;
		size++;
		
	}
	
	public T pop() {
		
		if(top==null)
			throw new EmptyStackException();
		
		// temp 변수
		T item = top.data;
		top = top.next;
		size--;
		
		return item;
		
	}
}
