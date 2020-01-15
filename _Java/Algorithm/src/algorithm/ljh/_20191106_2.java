package algorithm.ljh;

import java.util.Arrays;

import algorithm.custom.CustomList;

public class _20191106_2 {

	public static void main(String[] args) {
		int[] n = CustomList.randomIntArray(100, 10);
		System.out.println("중복 없는 랜덤 난수 배열 출력 :");
	    System.out.println(Arrays.toString(n));
	    System.out.println();
	   
	    
	    int[] m = selectionSort(n);
	    System.out.println("정렬된 배열");
	    System.out.println(Arrays.toString(m));
	    System.out.println();
	}
	//선택정렬
	//루프의 최대 원소를 찾는다. max
	//최대 원소와 맨 오른쪽 원소를 교환한다. temp, max, length
	//맨 오른쪽 원소를 제외한다. length-?
	//하나의 원소만 남을 때까지 위의 루프를 반복한다. length ==1?
	static int[] selectionSort(int[] n) {
		int max=0;
		int temp=0;
		int tempNum=0;
		int i=0;
		int j=0;
		for(i=0;i<n.length;i++) {
			for(j=0;j<n.length-i;j++) {
				if(max < n[j]) {
					max = n[j];
					tempNum=j;
				}
			}
			temp= n[n.length-i-1];
			n[n.length-i-1]=max;
			n[tempNum]=temp;
			max = 0;
		}
		return n;
	}
}