package algorithm.kjy;

import java.util.Scanner;

public class _20191030 
{
	public static void main(String[] args) 
	{
		int[] n = {8,1,45,21,22,37,6,8,2,79};
		solution1(n);
		int i = 10;
		solution2(i);
		solution3();
		solution4(n);
		int num = 153248976;
		solution6(num);
	}

	// 1
	static void solution1(int[] n)
	{
	    int maxNum = 0;
	    int minNum = n[1];
	    for(int i = 0; i < n.length; i++)
	    {
	    	if(n[i] >= maxNum) { maxNum = n[i]; }
	    	if(n[i] <= minNum) {minNum = n[i];}
	    }

	    System.out.println("최댓값은 : " + maxNum);
	    System.out.println("최솟값은 : " + minNum);
	}
	// 2
	static void solution2(int i)
	{
	    int sumValue = 0;
	    int n = 0;
	    int cnt=0;
	    while(true)
	    {
	    	sumValue += n++;
	    	cnt++;
	    	if(cnt > i) break;
	    }
	    System.out.println(i + "번째 항까지의 합 : " + sumValue);
	}
	
	// 3
	static void solution3()
	{
	    int sumValue = 0;
	    int n = 0;
	    int cnt=0;
	    while(true)
	    {
	    	if(cnt > 100) break;
	    	if(n%2 != 0)
	    		sumValue += n++;
	    	else
		    	sumValue -= n++;
	    	cnt++;
	    }
	    System.out.println("총합 : " + sumValue);
	}
	
	// 4
	static void solution4(int[] n)
	{
		 int[] answer = new int[n.length];
	    int tmp = 0;
	    for(int i = 0; i < n.length; i ++)
	    {
	    	answer[i] = n[i];
	    }
	    for(int i = 0; i < answer.length; i++)
	    {
	    	for(int j = 0; j < answer.length; j++)
	    	{
		    	if(answer[i] < answer[j])
		    	{
		    		tmp = answer[i];
		    		answer[i] = answer[j];
		    		answer[j] = tmp;
		    	}
	    	}
	    }
	    for(int answers : answer)
	        System.out.print(answers + ", ");
		System.out.println();
	}
	// 6
	static void solution6(int n)
	{
	    String answer = Integer.toString(n);
	    int[] num = new int[answer.length()];
	    int tmp;
	    String nstr, a;
	    for(int i = 0; i < answer.length(); i++)
	    {
	    	a = answer.substring(i, i+1);
		    num[i] = Integer.parseInt(a);
	    }
	    for(int i = 0; i < num.length; i++)
	    {
	    	for(int j = 0; j < num.length; j++)
	    	{
		    	if(num[i] < num[j])
		    	{
		    		tmp = num[i];
		    		num[i] = num[j];
		    		num[j] = tmp;
		    	}
	    	}
	    }
	    for(int i = 0; i < num.length; i++)
	    {
	    	nstr = Integer.toString(num[i]);
	    	System.out.print(nstr);
//	    	answer.substring(i, i+1) = nstr;
	    }
	    // 코드 작성
	    System.out.println("정렬된 수 : " + answer);
	    System.out.print("정렬된 수 : ");
	    for(int answers : num)
	        System.out.print(answers);
	}
}























