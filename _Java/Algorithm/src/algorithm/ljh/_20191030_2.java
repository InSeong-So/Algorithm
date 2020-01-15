package algorithm.ljh;

public class _20191030_2 {
	//  0 1 2 3 4 5 6 7 8 9 10
	// "1+2+4+7+11+16+...+i 의 순서로 나열된 수열의 i번째 항까지의 합 구하기"
	//       1 + (1+1) + (2+2)+(4+3)+(7+4)...
	// sum = 1 + (tem+j)
	public static void main(String[] args) {
		int i = 10; // 10번째 항까지의 합
		solution2(i);
	}

	static void solution2(int i){
	    int sumValue = 0;
	    int tem = 1;
	    // 코드 작성

	    for(int j=0;j<=i;j++) {
	    	tem = tem + j;
	    	sumValue += tem ; 
	    	System.out.print(tem + " ");
	    }
	    

	    System.out.println(i + "번째 항까지의 합 : " + sumValue);
	}

}
