package algorithm.jjw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class _20191106 {
	 private static Random rng = new Random();
	    
	    public static void main(String[] args) {
	        // 중복 없는 랜덤 난수 배열 생성
	        int[] n = randomIntArray(100,10);
	        System.out.println("중복 없는 랜덤 난수 배열 출력 :");
	        System.out.println(Arrays.toString(n));
	        System.out.println();
	    
	    
	     // 중복 없는 랜덤 난수 리스트 생성
	        List<Integer> n2 = randomIntList(100000,10000);
	        System.out.println("중복 없는 랜덤 난수 리스트 출력 :");
	        System.out.println(n2.toString());
	        System.out.println();
	    
	    
	    
	    
	        List<Integer> n3 = quickSort(n2);
	        System.out.println(n3.toString());
	        
	    
	    
	    }
	    
	    public static int[] randomIntArray(int maxInt, int arrSize)
	    {
	        if (maxInt < arrSize)
	            throw new IllegalArgumentException("숫자 범위의 갯수보다 배열의 크기가 클 수 없습니다.");
	        long start = System.currentTimeMillis();
	        Set<Integer> generated = new LinkedHashSet<Integer>();
	        while (generated.size() < arrSize)
	        {
	            Integer next = rng.nextInt(maxInt) + 1;
	            generated.add(next);
	        }
	        
	        int[] result = Arrays.stream(Arrays.copyOf(generated.toArray(), generated.size(), Integer[].class)).mapToInt(i -> i).toArray();
	        
	        long end = System.currentTimeMillis();
	        
	        long total = end - start;
	        
	        System.out.println("걸린 시간: " + total + " m/s");
	        
	        return result;
	    }
	    
	    public static List<Integer> randomIntList(int maxInt, int listSize)
	    {
	        if (maxInt < listSize)
	            throw new IllegalArgumentException("숫자 범위의 갯수보다 리스트의 크기가 클 수 없습니다.");
	        
	        long start = System.currentTimeMillis();
	        
	        Set<Integer> generated = new LinkedHashSet<Integer>();
	        
	        while (generated.size() < listSize)
	        {
	            Integer next = rng.nextInt(maxInt) + 1;
	            generated.add(next);
	        }
	        
	        List<Integer> result = new ArrayList<Integer>(generated);
	        
	        long end = System.currentTimeMillis();
	        
	        long total = end - start;
	        
	        System.out.println("걸린 시간: " + total + " m/s");
	        
	        return result;
	    }
	    
	    //----------------------------------------------------버블 정렬 메서드
	    public static void boubleSort(int [] n) {
	    	
	    	for(int i=0; i<n.length; i++) {
	    		for(int j = i+1; j<n.length-1; j++) {
	    			if(n[i]>n[j]) {
	    				int a = n[i];
	    				n[i] = n[j];
	    				n[j] = a;
	    			}
	    		}
	    	}
	    	System.out.print("버블 정렬:");
	    	System.out.println(Arrays.toString(n));
	    }
	    //-
	    public static void  insertionSort(int [] n) {
	    	
	    	for(int i=1; i<n.length; i++) {
	    		for(int j=i-1; j<1; j--) {
	    		}
	    	}
	    	System.out.print("삽입 정렬:");
	    	System.out.println(Arrays.toString(n));
	    }
	    public static void selectionSort(int [] n) {
	    	int maxNum = 0; //최대값을 저장
	    	int a = 0; //치환을 하기위한 변수
	    	for(int i= n.length-1; i<=0; i--) {
	    		for(int j=i; j<=0; j--) {
	    			if(maxNum<n[j]) {
	    				maxNum=n[j];
	    			}
	    		}
	    	}
	    	System.out.print("삽입 정렬:");
	    	System.out.println(Arrays.toString(n));
	    }
	    //----------------------------------------퀵 정렬
	    public static List<Integer> quickSort(List<Integer> n) {
	    	
	    	if(n.size() <2) 
	    		return n;
	    	
	    	int pivot = n.get(0);
	    	// pivot 보다 낮은 값
	    	List<Integer> lower = new ArrayList<Integer>();
	    	// pivot 보다 큰 값
	    	List<Integer> higher = new ArrayList<Integer>();	
	    	
	    	for(int i= 1; i<n.size(); i++) {
	    		if(n.get(i) < pivot)
	    			lower.add(n.get(i));
	    		
	    		else
	    			higher.add(n.get(i));
	    	}
	    	
	    	// lower 리스트가 정렬이 될때까지 분할해서 값을 추가한다.
	    	// higher 리스트가 정렬이 될때까지 분할해서 값을 추가한다.
	    	 List<Integer> result = quickSort(lower);
	    	 result.add(pivot);
	    	 result.addAll(quickSort(higher));
	    	//
	    	
	    	
	    	return result;
	    }
	    
}
