package algorithm.kjy;

import java.util.Arrays;

import algorithm.custom.CustomList;

public class _20191106 {

	public static void main(String[] args) 
	{
        int[] input = CustomList.randomIntArray();
        System.out.println("# ���� ���� ����!");
        System.out.println("���� x �迭 : " + Arrays.toString(input));
        bubbleSort(input);
        System.out.println("���� o �迭 : " + Arrays.toString(input));
        System.out.println(">> ���� ���� ����!");
        
        input = CustomList.randomIntArray();
        System.out.println("# ���� ���� ����!");
        System.out.println("���� x �迭 : " + Arrays.toString(input));
        insertionSort(input);
        System.out.println("���� o �迭 : " + Arrays.toString(input));
        System.out.println(">> ���� ���� ����!");
        
        input = CustomList.randomIntArray();
        System.out.println("# ���� ���� ����!");
        System.out.println("���� x �迭 : " + Arrays.toString(input));
        selectionSort(input);
        System.out.println("���� o �迭 : " + Arrays.toString(input));
        System.out.println(">> ���� ���� ����!");


	}

	private static void bubbleSort(int[] n) 
	{
		int t = 0;
		for(int i = 0; i < n.length; i++)
		{
			for(int j = i+1; j < n.length; j++)
			{
				if(n[i] > n[j])
				{
					t = n[i];
					n[i] = n[j];
					n[j] = t;				
				}
			}
		}
		
	}

	private static void insertionSort(int[] n) 
	{
		int t = 0;
		for(int i = 1; i < n.length; i++)
		{
			for(int j = i - 1; j >= 0; j--)
			{
				if(n[i] < n[j]) // n[1] > n[2]
				{
					t = n[i];
					n[i] = n[j];
					n[j] = t;					
				}
			}
		}
		
	}

	private static void selectionSort(int[] n) 
	{
		int t = 0;
		int max = 0;
		int len = n.length -1;
		for(int i = 0; i < n.length; i++)
		{
			if(n[i] > max)
				max = n[i];
			t = n[len];
			n[len] = max;
			

			
		}
		for(int j =len; j  )
		System.out.println(len);
	}



}
























