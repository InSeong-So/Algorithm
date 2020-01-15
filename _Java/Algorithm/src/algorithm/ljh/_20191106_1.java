package algorithm.ljh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.sun.javafx.scene.control.skin.CustomColorDialog;

import algorithm.custom.CustomList;

public class _20191106_1 {
	private static Random rng = new Random();
	
	public static void main(String[] args) {
		int[] n = CustomList.randomIntArray(100, 20);
		System.out.println("중복 없는 랜덤 난수 배열 출력 :");
	    System.out.println(Arrays.toString(n));
	    System.out.println();
	   
	    
	    int[] m = insertionSort(n);
	    System.out.println("정렬된 배열");
	    System.out.println(Arrays.toString(m));
	    System.out.println();
	   
	    
	    
	}
	/* 삽입정렬
	 *  시작회차 + 1의 위치 원소를 정렬된 배열과 비교한다.
	 *   자신의 위치를 찾아 삽입한다.
	 	루프의 시작이 맨 오른쪽이 될 때까지 반복한다. 
	 */
	static int[] insertionSort(int[] n) {
		// for, i = 1~ 자신의 위치까지 0부터 찾는다 자기자신까지.
		// for2, j = 0 ~ i위치까지 비교한다.
		int temp = 0;
		for(int i=1;i<n.length;i++) {//
			for(int j=0;j<i;j++) {
				if(n[j] > n[i] ) {
					temp = n[i];
					n[i] = n[j];
					n[j] = temp;
				}
			}
		}
		return n;
	}
}
