package dataStructure.stack;

import org.junit.Test;

import dataStructure.stack.Stack;

public class StackTest {

	@Test
	public void test() {
		Stack stack = new Stack(); 
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.isEmpty());
		System.out.println(stack.pop());
		System.out.println(stack.isEmpty());
	}
}
