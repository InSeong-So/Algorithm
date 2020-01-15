package algorithm.hdy;

public class _20191023 {
	// 1주차 알고리즘 스터디 알고리즘 문제 풀이 
	
	public static void main(String[] args) {
		System.out.println("1번 문제");
		// 1번 문제 문자열 선언 초기화 
		// 문자열에 있는 문자를... 뽑아서 비교... 배열..
		String str = "eclipse";		
		solution1(str);
		
		System.out.println("2번 문제");
		// 2번 문제 문자열 선언
		str = "ecli ps e "; // 공백이 3개 여기서 문자열 길이는 10 3개에 %20 이 들어가면 3*3는 9개... 그래서 최종 길이는 19
		// System.out.println(str.charAt(4));
		char[] strArr = solution2(str, 19);		
		System.out.println(strArr);
		
		System.out.println("3번 문제");
		//3번 문제 
		int[] array = {1, 6, 2, 11,5, 3, 7, 4, 10, 9};
		int i =2, j=8, k=3;
		int[] temp = {i,j,k};
		int[][] commands = new int[2][];	// 비정방형 배열 
		commands[0] = array;
		commands[1] = temp;		
		int sol[] = solution3(array, commands);		
		System.out.println(sol[commands[1][2]-1]);
		
		System.out.println("4번 문제");
		// 4번 문제 
		int[] n = {1, 5, 4, 3, 2};
		for(int h :n) {
			System.out.print(h+" ");
		}
		System.out.println();
		solution4(n);
	}
	
	//		- "중복이 없는가" 1번 문제
	//		  * > 문자열이 주어졌을 때, 이 문자열에 같은 문자가 중복되어 등장하는지 확인하는 알고리즘을 작성하라.
	//		  * > 자료구조를 추가로 사용하지 않고 풀 수 있는 알고리즘 또한 고민하라.
	static void solution1(String str){
		char[] arr = str.toCharArray();
		
		for(int i =0; i<str.length();i++) {
			for(int j=i;j<str.length();j++) {
				if(arr[i]==arr[j]) {
//					System.out.println(arr[i]);
					System.out.println("증복 된 문자가 있습니다.");
					return;
				}
			}		
		}
	    System.out.println("중복 된 문자가 없습니다.!");
	}
	
	
	//	"URI변환"	2번 문제 
	//* 문자열에 들어 있는 모든 공백을 '%20'으로 바꿔 주는 메서드를 작성하라.
	//* 최종적으로 모든 문자를 다 담을 수 있을 만큼 충분한 공간이 이미 확보되어 있다. 공간 확보 문자열의 최종 길이가 함께 주어진다.
	//* 문자열의 최종 길이가 함께 주어진다고 가정해도 된다.
	//* (자바로 구현한다면 배열 안에서 작업할 수 있도록 문자 배열(character array)를 이용하길 바란다)
	static char[] solution2(String str, int trueLength){
	    char[] array = new char[trueLength];	// 미정
	    char[] twe = {'%', '2', '0'};
	    //  System.out.println(twe);
	    int temp = 0;
	    
	    for(int i=0;i<str.length();i++) {
	    	// 공백 있나요?
	    	if(str.charAt(i) == ' '){ //공백 있으면 %20 넣기 
	    		// System.out.println("temp: "+temp);	// 4, 7, 9나옴 공백 뽑기 완료 
	    		for(int j=0; j<3; j++) {
	    			array[temp] = twe[j];
	    			// System.out.println(temp +"자리에 넣기 "+twe[j]);
	    			temp++;
	    		}
	    		continue;
	    	}
	    	// 어레이에 str 그대로 저장
	    	array[temp] = str.charAt(i);
	    	temp++;
	    }
	    // charAt(index)
	    //" "이면 %20을....넣는다.
	    	    
	    return array;
	}
	
	// 3번 문제 
	//	배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.
	//
	//	예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면
	//	array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
	//	1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
	//	2에서 나온 배열의 3번째 숫자는 5입니다.
	//
	//	배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, commands의 모든 원소에 대해
	//	앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
	//
	//	[제한사항]
	//	array의 길이는 1 이상 100 이하입니다.
	//	array의 각 원소는 1 이상 100 이하입니다.
	//	commands의 길이는 1 이상 50 이하입니다.
	//	commands의 각 원소는 길이가 3입니다.
	  
	
	public static int[] solution3(int[] array, int[][] commands) {
		System.out.println("::: solution3 :::");
		int now =0;
		if(commands[1][0] > commands[1][1]) {
			now = commands[1][0] - commands[1][1] +1;
		}
		else {
			now = commands[1][1] - commands[1][0]+1;
		}
		
		System.out.println(now);
	    int[] answer = new int[now];
	    
	    int count=0;
	    System.out.println((commands[1][0]-1)+" ~ "+(commands[1][1]-1));
	    for(int i = commands[1][0]-1 ; i < commands[1][1] ; i++) {
	    	answer[count] = array[i];
	    	System.out.println("count:"+count+i);
	    	
    		for(int j=0;j<count;j++) {
    			if(answer[j]>answer[count]) {
    				int temp = answer[j];
    				answer[j] = answer[count];
    				answer[count]=temp;
    			}
    		}
	    	
	    	
	    	count++; // 0 -> 1 2 3 4 
	    	if(count==commands[1][1]) {
	    		System.out.println("탈출");
	    		break;
	    	}
	    }

	    for (int i : answer) {
			System.out.print(i+"  ");
		}  
	    System.out.println("END");
	    return answer;
	}
	
	
	//	동혁이는 나무 조각을 5개 가지고 있다. 나무 조각에는 1부터 5까지 숫자 중 하나가 쓰여져 있다.
	//	또, 모든 숫자는 다섯 조각 중 하나에만 쓰여 있다.
	//
	//	동혁이는 나무 조각을 다음과 같은 과정을 거쳐서 1, 2, 3, 4, 5 순서로 만들려고 한다.
	//
	//	첫 번째 조각의 수가 두 번째 수보다 크다면, 둘의 위치를 서로 바꾼다.
	//	두 번째 조각의 수가 세 번째 수보다 크다면, 둘의 위치를 서로 바꾼다.
	//	세 번째 조각의 수가 네 번째 수보다 크다면, 둘의 위치를 서로 바꾼다.
	//	네 번째 조각의 수가 다섯 번째 수보다 크다면, 둘의 위치를 서로 바꾼다.
	//
	//	만약 순서가 1, 2, 3, 4, 5 순서가 아니라면 1 단계로 다시 간다.
	//
	//	처음 조각의 순서가 주어졌을 때, 위치를 바꿀 때 마다 조각의 순서를 출력하는 프로그램을 작성하시오.
	public static void solution4(int[] n) {
		
		for(int i =0; i< n.length-1 ; i++) {
			System.out.println(":::"+ i +":::");
			
			
			if(n[i] > n[i+1]) {
				int temp = n[i];
				n[i] = n[i+1];
				n[i+1]=temp;
			}
			
			if(i == n.length-2) {
				System.out.println("came in");
				for(int j =0; j < i ; j++) {
					for(int k = j;k<n.length-1;k++) {
						if(n[k]>n[k+1]) {
							i=0;
							break;
						}	
					}
					if(i==0) {
						break;
					}
				}
				
			} 
			System.out.println("확인");
			for(int h :n) {
				System.out.print(h+" ");
			}
			System.out.println();
		}
		
		System.out.println("최종");
		for(int h :n) {
			System.out.print(h+" ");
		}
	}
}
