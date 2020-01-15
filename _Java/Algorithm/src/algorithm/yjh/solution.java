package algorithm.yjh;

public class solution {
	public static void main(String[] args) {
		System.out.println("1번 문제");
		int[] arr = { 8, 1, 45, 21, 22, 37, 6, 8, 2, 79, 80, 0 };
		solution1(arr);

		System.out.println("2번 문제");
		// 주어지는 값
		int i = 10; // 10번째 항까지의 합
		solution2(i);

		System.out.println("3번 문제");
		// 주어지는 값 없음
		solution3();

		System.out.println("4번 문제");
		// 주어지는 값
		int[] n = { 8, 1, 45, 21, 22, 37, 6, 8, 2, 80, 79, };
		for (int answers : n) {
			System.out.print(answers + ", ");
		}
		System.out.println();
		solution4(n);
		System.out.println();

		System.out.println("5번 문제 스캐너 사용");
//		Scanner sc = new Scanner(System.in);
//		int hell = sc.nextInt();
//		System.out.println(hell);		
		// solution5();
		System.out.println("5번 문제 버퍼 사용");
//		solution5_2();

		System.out.println("6번 문제");
		// 주어지는 값
		int nums = 153248976;
		// solution6(nums);

		System.out.println("7번 문제 ");
		// 주어지는 값
		int[] nums2 = { 6, 2, 10 };
		// solution7(nums2);
	}
	
	static void solution1(int[] n) {
		int maxNum = n[0];
		int minNum = n[0];

		for (int i = 1; i < n.length; i++) {
			System.out.print("n : " + n[i] + "\n");
			if (minNum > n[i]) {
				minNum = n[i];
			} else {
				maxNum = n[i];
			}
		}

		System.out.println("최댓값은 : " + maxNum);
		System.out.println("최솟값은 : " + minNum);
	}
	
	static void solution2(int i) {
		// 1+2+4+7+11+16+...+i
		// 0+1, 1+1, 2+2, 3+4, 5+6,
		int num = 1;
		int sumValue = 0;

		 for(int j = 0; j < i; j++) {
		    	sumValue += j + num; //2 
		    	num = sumValue;//2
		    }
		System.out.println();
		System.out.println(i + "번째 항까지의 합 : " + num);
	}
	
	static void solution3() {
		// 1-2+3-4+5-6...
		int sum = 0;
		for (int i = 1; i < 101; i++) {
			if (i % 2 == 0) {
				sum -= i;
				System.out.print(i + "+");
			}
			if (i % 2 == 1) {
				System.out.print(i + "-");
				sum += i;
			}

		}
		System.out.println();

		System.out.println("총합 : " + sum);
	}
	
	static void solution4(int[] n){
	    int[] answer = {};
	    // 코드 작성
	    // {8,1,45,21,22,37,6,8,2,79}
	    int x = 0;
	    for(int i = 0; i < n.length; i++) {
	    	for(int j = i; j < n.length; j++) {
	    		if(n[i] > n[j]) {
	    			x = n[j];
	    			n[j] = n[i];
	    			n[i] = x;
	    		}
	    	}
	    } 
	    answer = n;
	    for(int answers : answer)	
	        System.out.print(answers + ", ");
	}
	
}
