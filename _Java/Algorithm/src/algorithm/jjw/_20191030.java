package algorithm.jjw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class _20191030 {
	 static int[] n = {8,1,45,21,22,37,6,8,2,79};
	 static int x = 153248976;
	 static int[] y = {3, 30, 34, 5, 9}; 
	public static void main(String[] args) {
		solution1(n);
		solution2(10);
		solution3();
		solution4(n);
		solution5();
		solution6(x);
		solution7(y);
		
	}
	
	// 1번문제
	// 주어지는 값
	// 최솟값과 최댓값을 구하기

	static void solution1(int[] n){
	    int maxNum = 0;
	    int minNum = 0;
	    int a = 0;
	    // 코드 작성
	    for(int i=0; i<n.length; i++) {
	    	for(int j=i; j<n.length; j++) {
	    		if(n[i]>n[j]) {
	    			a = n[j];
	    			n[j] = n[i];
	    			n[i] = a;
	    		}
	    	}
	    }
	    maxNum = n[n.length-1];
	    minNum = n[0];
	    System.out.println("최댓값은 : " + maxNum);
	    System.out.println("최솟값은 : " + minNum);
	}
	
	// 2번문제
	// 주어지는 값
	// 10번째 항까지의 합 1+2+4+7+11...

	static void solution2(int i){
	    int sumValue = 0;
	    int x = 1;
	    //첫번째항은 
	    /*
	     0+1 = 1
	     1+1 = 2
	     2+2 = 4
	     3+4 = 7
	     
	     
	     */
	    // 코드 작성
	    for(int a=0; a<i; a++) {
	    	sumValue += a+x; //2 
	    	x = sumValue;//2
	    }
	    System.out.println(i + "번째 항까지의 합 : " + sumValue);
	}
	
	// 3번문제
	// 주어지는 값 없음

	static void solution3(){
	    int sumValue = 0;
	    
	   
	    // 코드 작성
	    for(int i=1; i<101; i++) {
	    	if(i%2==0) {
	    		i = i*(-1);
	    	}
	    	sumValue += i;
	    	if(i%2==0) {
	    		i = i*(-1);
	    	}
	    }
	    System.out.println("총합 : " + sumValue);
	}
	
	// 4번문제
	// 주어지는 값

	static void solution4(int[] n){
	    int[] answer = {};
	    int a = 0;
	    // 코드 작성
	    for(int i=0; i<n.length; i++) {
	    	for(int j=i; j<n.length; j++) {
	    		if(n[i]>n[j]) {
	    			a = n[j];
	    			n[j] = n[i];
	    			n[i] = a;
	    		}
	    	}
	    }
	    answer = n;
	    for(int answers : answer)
	        System.out.print(answers + ", ");
	}
	//5번문제
	static void solution5(){
	    Scanner sc = new Scanner(System.in);
	    int count = Integer.parseInt(sc.nextLine().trim());
	    
	    String [] a = {};
	    // 코드 작성
	}
	//6번문제
	// 주어지는 값

	static void solution6(int x){
	    String answer = "";
	    String y = Integer.toString(x);
	    
	    for(int i=0; i<y.length(); i++) {
	    	
	    }
	    
	    
	    // 코드 작성
	    System.out.println("정렬된 수 : " + answer);
	}
	//7번문제
	// 주어지는 값


	static String solution7(int[] y){
	    String answer = "";
	    String [] x = {};
	    int a = 0;
	    int index = 0;
	    // 코드 작성
	    
	    for(int i=0; i<y.length; i++) {
	    	for(int j=0; j<y.length; j++) {
	    		a = n[j];
    			n[j] = n[i];
    			n[i] = a;
//    			x[index] = 
	    	}
	    }
	    
	    System.out.println("정수를 이어 붙여 만든 가장 큰 수는 : " + answer);
	    return answer;
	}
}
