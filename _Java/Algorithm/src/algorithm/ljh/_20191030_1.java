package algorithm.ljh;

public class _20191030_1 {
	public static void main(String[] args) {
	//주어지는 값
		int[] n = {8,1,45,21,22,37,6,8,2,79};
		solution1(n);
	}
	static void solution1(int[] n){
	    int maxNum = 5;
	    int minNum = 5;
	    
	    // 코드 작성
	    for(int i=0;i<n.length;i++) {
	    	
	    	if(maxNum < n[i]) {
	    		maxNum = n[i];
	    	}
	    	if(minNum > n[i]) {
	    		minNum = n[i];
	    	}
	    }

	    System.out.println("최댓값은 : " + maxNum);
	    System.out.println("최솟값은 : " + minNum);
	}
}
