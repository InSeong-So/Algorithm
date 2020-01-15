package algorithm.ljh;

public class _20191030_4 {
	//- "int 배열이 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오."
	
	public static void main(String[] args) {
		// 주어지는 값
		int[] n = {8,1,45,21,22,37,6,8,2,79};
					//1 2 6 8 8 21 22 37 45 79 
		solution4(n);
	}
	static void solution4(int[] n){
	    int[] answer = new int[10];
	    int tem = 0;
	    // 코드 작성
	    for(int i=0;i<n.length;i++) {
	    	for(int j=i+1;j<n.length;j++) {
	    		if(n[i] > n[j]){
	    			tem = n[i];
	    			n[i] = n[j];
	    			n[j] = tem;
	    		}
	    		
	    	}
	    	answer[i] = n[i];
    		System.out.println(n[i]);
	    }

	    for(int answers : answer) {
	    	
	    	
	        System.out.print(answers + ", ");
	    }
	}
}
