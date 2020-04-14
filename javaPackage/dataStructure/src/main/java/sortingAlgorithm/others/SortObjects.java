package sortingAlgorithm.others;

import java.util.Arrays;

public class SortObjects {
	public static void main(String[] args) {

		MyObject array[] = new MyObject[5];
		array[0] = new MyObject("red", 0);
		array[1] = new MyObject("blue", 1);
		array[2] = new MyObject("red", 2);
		array[3] = new MyObject("blue", 3);
		array[4] = new MyObject("red", 4);

		System.out.println("Before Sort:");
		for (MyObject o : array) {
			System.out.println(o.key + " : " + o.number);
		}

		Arrays.sort(array);

		System.out.println("After Sort:");
		for (MyObject o : array) {
			System.out.println(o.key + " : " + o.number);
		}
	}
}

class MyObject implements Comparable<MyObject> {

	String key;
	int number;

	MyObject(String key, int number) {
		this.key = key;
		this.number = number;
	}

	public int compareTo(MyObject o) {
		return o.key.compareTo(this.key);
	}
}
