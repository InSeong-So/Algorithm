package algorithm.hdy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class _20191030 {

	public static void main(String[] args) {
		System.out.println("1번 문제");
		int[] n = { 8, 1, 45, 21, 22, 37, 6, 8, 2, 79, 80, 0 };
		solution1(n);

		System.out.println("2번 문제");
		// 주어지는 값
		int i = 10; // 10번째 항까지의 합
		solution2(i);
		
		System.out.println("3번 문제");
		// 주어지는 값 없음
		solution3();

		System.out.println("4번 문제");
		// 주어지는 값
		int[] j = {8,1,45,21,22,37,6,8,2,80,79,};
		for(int answers : j) {
	    	System.out.print(answers + ", ");
	    }
		System.out.println();
		solution4(j);
		System.out.println();

		System.out.println("5번 문제 스캐너 사용");
//		Scanner sc = new Scanner(System.in);
//		int hell = sc.nextInt();
//		System.out.println(hell);		
		solution5();
		System.out.println("5번 문제 버퍼 사용");
//		solution5_2();
		
		System.out.println("6번 문제");
		// 주어지는 값
		int nums = 153248976;
		solution6(nums);
		
		System.out.println("7번 문제 ");
		// 주어지는 값
		int[] nums2 = {3, 30, 34, 5, 9};	
		solution7(nums2);	// 9 5 34 3 30

	}

	// 1번 문제
	// "최댓값과 최솟값 구하기"
	// 주어지는 값
	static void solution1(int[] n) {
		int maxNum = 0;
		int minNum = 0;
		maxNum = minNum = n[0];

		for (int i = 1; i < n.length; i++) {
//			System.out.println(n[i]);
			if (minNum > n[i]) {
				minNum = n[i];
//				System.out.println("min: "+minNum);
			} else {
				maxNum = n[i];
			}
		}

		System.out.println("최댓값은 : " + maxNum);
		System.out.println("최솟값은 : " + minNum);
	}

	// 2번 문제 
	//  1 1 2 3 4 
	//  1 2 3 4 5
	// "1+2+4+7+11+16+...+i 의 순서로 나열된 수열의 i번째 항까지의 합 구하기"
	static void solution2(int i) {
		int sumValue = 0;
		int sum = 1;
		
		System.out.print(sumValue);
		
		for (int j = 0; j <= i; j++) {
//			System.out.println(j+" "+sum);
			sum = sum+j;	// 1, 1+1=2, 2+2
//			System.out.println(sum);
			
			sumValue += sum;
			System.out.print(" + "+sum);	 
		}
		System.out.println();
		System.out.println(i + "번째 항까지의 합 : " + sumValue);
	}
	
	//	3번 - 배열 기초
	//
	//	- "1-2+3-4+5-6+...+99-100의 합 구하기"
	
	static void solution3(){
	    int sumValue = 0;
	    int temp = 1;
	    System.out.print(0);
	    for(int i=1;i<=100;i++) {
	    	System.out.print(" + "+temp*(i));
	    	sumValue += i*(temp);
	    	temp *= (-1);
	    }
	    System.out.println();

	    System.out.println("총합 : " + sumValue);
	}
	
	//	4번 - 정렬 기초
	//	- "int 배열이 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오."
	static void solution4(int[] n){
//	    int[] answer = {};
//	    System.out.println("solution4");
	    // n 배열의 값들을 정렬 해주는 메소드 arrays 안에 있는 sort 내장 함수 자바 기본 라이브러리?
	    Arrays.sort(n);

	    for(int answers : n) {
	    	System.out.print(answers + ", ");
	    }
	    
	}
	
	
	// 5번 문제
//	- "알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오."
//	  * > 길이가 짧은 것부터
//	  * > 길이가 같으면 사전 순으로}

	// jhhh hh ahhh

	// 스캐너 사용시
	static void solution5() {
		System.out.println("진입");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine(); // 라인 전체 읽어 오기

		System.out.println(name.split(" "));
		String arr[] = name.split(" "); // 공백으로 나눈다.

		System.out.println(arr.length);
		for (String i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		for (int i = 0; i < arr.length - 1; i++) {
			// 글자수 검사 
			for (int j = i; j < arr.length - 1; j++) {
				// 글자수에 따라 정렬 
				if (arr[j].compareTo(arr[j + 1]) > 0 ) {
					System.out.println("위치를 바꿉니다. " + arr[j + 1].length());
					String temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			
			// 글자수 같으면 알파벳 순 검사 
			if (arr[i].compareTo(arr[i + 1]) > 0 ) {
				System.out.println("같습니다. 검사 합니다");
				// 문자 비교
				for (int num = 0; num < arr[i].length(); num++) {
					if (arr[i].charAt(num) > arr[i + 1].charAt(num)) {
						System.out.println("앞 놈이 알파벳순으로 빠르다 바꾼다!!");
						String temp = arr[i];
						arr[i] = arr[i + 1];
						arr[i + 1] = temp;
						break;
					}
				}

			}
		}

		for (String i : arr) {
			System.out.print(i + " ");
		}
		System.out.println("END");

	}

	// 5번 문제 버퍼드리더 사용시
	static void solution5_2() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	    int n = Integer.parseInt(br.readLine());
		// 나.. 나중에... 내...내일.. ㅠ
		// 코드 작성
	}
	
	// 6번 문제 
	// - "수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬하시오."
	static void solution6(int n){
//	    String answer = Integer.toString(n);
	    char[] ans = Integer.toString(n).toCharArray();
	    Arrays.sort(ans);
//	    for(char answer : ans){
//		   System.out.print(answer);
//	   }
	    int len =0,len2 =0;
	    
	    if(ans.length % 2 ==0) {
	    	len2 = len =ans.length;
	    }else {
	    	len2 = len = ans.length-1;
	    }
	   for(int i =0;i<len/2;i++) {
		   	char temp = ans[i];
		   	ans[i] = ans[len2];
		   	ans[len2] = temp;
			len2--;
	   }
	   System.out.print("정렬된 수 : ");
	   for(char answer : ans){
		   System.out.print(answer);
	   }
	   System.out.println();
	   
	}
	
	
	//	7번 문제 
	//	- "0 또는 양의 정수가 주어질 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 출력하시오."
	//	  * > 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210이다.
	//	  * > 0 또는 양의 정수가 담긴 배열 n이 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성하시오.
	static void solution7(int[] n){ 
		Arrays.sort(n);
		
	    // {3, 30, 34, 5, 9}
	    // 잘 모르겠음... 도움!!!! 헬프!!!! 도움 !!!! 
	    
	    
	   for(int i =0;i<n.length-1;i++) {
		  for(int j =i;j<n.length-1;j++) {
				String n1 = String.valueOf(n[j]);
			   	String n2 = String.valueOf(n[j+1]); 
			   	if(n1.compareTo(n2) > 0) {	//?
			   		
			   	}else {
			   		if(n1.charAt(0) < n2.charAt(0)) {
				   		int temp = n[i];
				   		n[i] = n[i+1];
				   		n[i+1] = temp;
				   	}
			   	}
			   			   
		  }
		   	
	   }
	   
	   System.out.print("정수를 이어 붙여 만든 가장 큰 수는 : ");
	   for(int answer : n){
		   System.out.print(answer);
	   }
	   System.out.println();
	}

}