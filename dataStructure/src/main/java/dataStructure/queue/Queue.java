package dataStructure.queue;

import java.util.NoSuchElementException;

public class Queue<T> {

	private Node<T> front;
	private Node<T> rear;
//	private int size;
//	private Object[] queueArray;

	private class Node<T> {
		private T data;
		private Node<T> next;

		public Node(T data) {
			this.data = data;
		}
	}

	public void add(T input) {
		Node<T> newNode = new Node<T>(input);
		if (rear != null) {
			rear.next = newNode;
		}
		rear = newNode;
		if (front == null) {
			front = rear;
		}
	}

	public T remove() {
		if (front == null) {
			throw new NoSuchElementException();
		}

		T data = front.data;
		front = front.next;

		if (front == null) {
			rear = null;
		}

		return data;
	}

	public T peek() {
		if (front == null) {
			throw new NoSuchElementException();
		}
		return front.data;
	}

	public boolean isEmpty() {
		return front == null;
	}
}
