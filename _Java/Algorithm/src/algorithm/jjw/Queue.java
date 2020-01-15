package algorithm.jjw;

import java.util.NoSuchElementException;

public class Queue<T> {
	
	//가장 먼저 삽입된 데이터의 위치
	private Node<T> front;
	
	//가장 나중에 삽입된 데이터의 위치
	private Node<T> back;
 	
	private int size = 0;
	// 데이터를 암시하는 클래스
	private class Node<T> {

		// 데이터
		private T data;

		// 다음 데이터를 암시하는 포인터
		private Node<T> next;

		// 생성자, 처음 생성 시 스택으 데이터는 하나, 다음 데이터는 존재하지 않음
		public Node(T input) {
			this.data = input;
			this.next = null;
		}
	}
	
	//enqueue 입력
	public void enqueue (T input) {
		Node<T> newNode = new Node<T>(input);
		
		if(back != null)
			back.next = newNode;
		
		back = newNode;
		
		if(front == null)
			front = back;
	}
	
	//dequeue 삭제
	public T dequeue() {
		if(front == null)
			throw new NoSuchElementException();
		
		T item = front.data;
		front = front.next;
		if(front == null)
			back = null;
		
		return item;
	}
	
	public T peek() {
		if(front == null)
			throw new NoSuchElementException();
		
		return front.data;
	}
	
	
}
