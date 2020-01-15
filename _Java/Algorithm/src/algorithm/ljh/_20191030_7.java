package algorithm.ljh;

public class _20191030_7 {
	/*- "0 또는 양의 정수가 주어질 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 출력하시오."
	  * > 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210이다.
	  * > 0 또는 양의 정수가 담긴 배열 n이 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성하시오.
	*/// 주어지는 값
	

	
	public static void main(String[] args) {
		//  16 * 5?
		int[] n = {3, 30, 34, 5, 9};
		String maxNum = solution7(n);
	}
	static String solution7(int[] n){
	    String answer = "";
	    
	    
	    System.out.println("정수를 이어 붙여 만든 가장 큰 수는 : " + answer);
	    return answer;
	}
}
