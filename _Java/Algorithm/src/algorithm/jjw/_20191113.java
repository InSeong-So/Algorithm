package algorithm.jjw;

import java.util.Arrays;

import algorithm.custom.CustomList;

public class _20191113 {
	
	public static void main(String[] args)
    {
        int[] n = CustomList.randomIntArray(11, 10);
    }
    
    public static int seqSearch(int[] n, int t) //선형검색
    {
        int i = 0;
        
        while (true)
        {
            if (i == n.length)
                return -1;
            if (n[i] == t)
                return i;
            
            i++;
        }
    }
    public static int BinarySearch(int [] n,int t) { //이진검색
       
    	Arrays.sort(n);
    	
    	// 검색 실패 시
    	int left = 0;
    	int right = n.length-1;
    	
    	do {
    		int center = (left+right)/2;
    		// 완료조건 1
    		if(n[center] == t) {
    			return n[center];
    		} else if(n[center] > t) {
    			left = center +1;
    		} else {
    			right = center -1;
    		}
    	} while(left <= right);
        return -1;
    }
    
}
