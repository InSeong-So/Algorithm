package algorithm.lsh;

import java.util.Arrays;

import algorithm.custom.CustomList;
import javafx.scene.chart.BubbleChart;

public class _20191106 {
	public static void main(String[] args) {
		int[] input = CustomList.randomIntArray();
		System.out.println("::::::::::::::::::::::::::::::::::::::버블 정렬 시작:::::::::::::::::::::::::::::::::::::::");
		System.out.println("정렬 전 : " + Arrays.toString(input));
		Bubble(input);
		System.out.println("정렬후 : " + Arrays.toString(input));
		System.out.println("::::::::::::::::::::::::::::::::::::::버블 정렬 끝!:::::::::::::::::::::::::::::::::::::::");
		
		input = CustomList.randomIntArray();
		System.out.println("::::::::::::::::::::::::::::::::::::::삽입 정렬 시작:::::::::::::::::::::::::::::::::::::::");
		System.out.println("정렬 전 : " + Arrays.toString(input));
		Insert(input);
		System.out.println("정렬후 : " + Arrays.toString(input));
		System.out.println("::::::::::::::::::::::::::::::::::::::삽입 정렬 끝!:::::::::::::::::::::::::::::::::::::::");
		
		
		System.out.println("::::::::::::::::::::::::::::::::::::::선택 정렬 시작:::::::::::::::::::::::::::::::::::::::");
		System.out.println(Arrays.toString(input));
		Select(input);
		System.out.println("::::::::::::::::::::::::::::::::::::::선택 정렬 끝!:::::::::::::::::::::::::::::::::::::::");
	}
	public static void Bubble(int n[]) {
		// 배열의 수를 하나하나 비교해감 
		// 교환할 공간을 생성
		int y = 0;
		for(int i=0; i < n.length; i++) {
			for(int j= i+1; j < n.length ; j++) {
				if(n[i] > n[j]) {
					y = n[i];
					n[i] = n[j];
					n[j] = y;
				}
			}
		}
	}
	public static void Insert(int n[]) {
		// 배열의 수를 비교하는데 인덱스가 1부터 시작
		// 교환할 공간을 생성
		/*
		 * 시작회차 + 1의 위치 원소를 정렬된 배열과 비교한다. 자신의 위치를 찾아 삽입한다.
		 */
		int y =0;
		for(int i=1; i< n.length; i++) {
			for(int j= i-1; j<n.length; j++) {
				if(n[j] > n[i]) {
					y = n[i];
					n[i] = n[j];
					n[j] = y;
				}
			}
		}
	}
	public static void Select(int n[]) {
		/*
		 * 루프의 최대 원소를 찾는다. 최대 원소와 맨 오른쪽 원소를 교환한다. 맨 오른쪽 원소를 제외한다.
		 */
		// 마지막 숫자는 자동으로 정렬되기 때문에 (숫자 개수-1) 만큼 반복한다.` => 가장 마지막은 가장 큰 수가 남게 됨으로 정렬이 필요 없다
		int y=0;// 최대 값
		int index = 0;
		for(int i=0; i< n.length-1; i++) {
			index = i; // n을 순차적으로 조회하기 위해 n의 length 인 i 를 부여
			for(int j=i+1; j<n.length; j++) {
				if( n[j] > n[index]) {
					j = index; //  n 번째와 n+1 번째를 n.length 만큼 비교 
				}
				 // 최대 값
			}
			n[index] = y;
			System.out.println(y);
		}
	}
}
