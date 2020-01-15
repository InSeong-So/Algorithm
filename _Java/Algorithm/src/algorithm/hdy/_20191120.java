package algorithm.hdy;

import java.util.*;
import java.util.EmptyStackException; 
import java.util.NoSuchElementException;
 

public class _20191120 {
	 public static void main(String[] args) {
		 int[] array = {1, 5, 2, 6, 3, 7, 4};
		 int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		 
		int[] hey = solution(array,commands);
		
		System.out.println(Arrays.toString(hey));
	}
	 public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
        for(int i =0;i<commands.length;i++){
            int[] temp = new int[commands[i][1] - commands[i][0]+1];
            int t=0;
            for(int j = commands[i][0]-1;j<commands[i][1];j++){
                temp[t] = array[j];
                t++;
            }
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }
 
        return answer;
    }
	 
	class Solution {
		public int[] solution(int[] array, int[][] commands) {
	        int[] answer = new int[commands[0].length];
	        for(int i =0;i<commands[0].length;i++){
	            int[] temp = new int[commands[i][0] - commands[i][1]];
	            for(int j = 0;j<temp.length;j++){
	                temp[0] = array[j];
	            }
	            Arrays.sort(temp);
	            answer[i] = array[commands[i][2]];
	        }

	        return answer;
	    }
	}
	
	public class Queue<T>{
		
		// 대가리  
		private Node<T> front;
		// 발 
		private Node<T> back;
		// 크기 (not important)
		private int size = 0; 
		
		//생성
		private class Node<T>{
			private T data;
			private Node<T> next;
			
			// 생성 초기화 (생성자)
			public Node(T input){
				this.data = input;
				this.next = null;
			}
		}
		
		// 입출력 -> 큐: enqueue, dequeue | 스택: push, pop
		
		public void enqueue(T input) {
			Node<T> newNode = new Node<T>(input);
			if(back != null)
				back.next = null;
			front = newNode;
			if(front == null)
				front = back;
		}
		
		public T dequeue() {
			if(front == null)
				throw new NoSuchElementException();	// 원소가 업서용 
			T item = front.data;
			front = front.next;
			if(front ==null)
				back = null;
			size--;
			return item;
		}
		
		public T peak() {
			if(front == null)
				throw new NoSuchElementException();
			return front.data;
		}
		
	}
	
	public class Stack<T>{
		
		private Node<T> top;
		private int size = 0; 
		
		//생성
		private class Node<T>{
			private T data;
			private Node<T> next;
			
			// 생성 초기화 (생성자)
			public Node(T input){
				this.data = input;
				this.next = null;
			}
		}
		
		// 값 조회
		public T peak() {
			if(top == null)
				throw new EmptyStackException();	// 데이터가 없어용
			return top.data;
		}
		
		// 갑 추가
		public void push(T input) {
			Node<T> newNode = new Node<T>(input);
			newNode.next = top;
			top = newNode;
			size++;
		}
		
		// 스택에서 제거
		public T pop() {
			if(top==null)
				throw new EmptyStackException();
			T item = top.data;
			top = top.next;
			size--;
			return item; 
		}
		
	}
}
