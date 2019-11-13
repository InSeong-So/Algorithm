package dataStructure.list.linkedlist;

import org.junit.Test;

import dataStructure.list.linkedlist.LinkedList;

public class LinkedListTest {

	@Test
	public void test() {
		LinkedList numbers = new LinkedList();

		numbers.addLast(10);
		numbers.addLast(20);
		numbers.addLast(30);

		LinkedList.ListIterator i = numbers.listIterator();
		i.add(5);
		i.next();
		i.add(15);
		System.out.println(numbers);

	}

}
