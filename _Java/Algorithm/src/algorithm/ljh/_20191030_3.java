package algorithm.ljh;

public class _20191030_3 {
	// 	  "1-2+3-4+5-6+...+99-100의 합 구하기"
	// sum i+(i*-1)
	public static void main(String[] args) {
		solution3();
	}
	

	static void solution3(){
	    int sumValue = 0;
	    int sw = -1;
	    
	    // 코드 작성
	    for(int i=1;i<=100;i++) {
	    	sw = sw *  (-1);
	    	sumValue += i * sw;
	    	System.out.println(sumValue);
	    }
	    
	    System.out.println("총합 : " + sumValue);
	}
}
