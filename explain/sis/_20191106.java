import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import algorithm.custom.CustomList;

/**
 * 3회차 정렬의 구현
 * 
 * @author 소인성
 * @date 2019-11-06
 */
public class _20191106 extends CustomList
{
    static long start = 0;
    
    static long end = 0;
    
    static long total = 0;
    
    public static void main(String[] args)
    {
        int[] n = randomIntArray();
        //        List<Integer> n2 = randomIntList();
        
        // 정렬 시작
        System.out.println("정렬 전 : " + Arrays.toString(n));
        //        System.out.println("정렬 전 : " + n2.toString());
        start = System.currentTimeMillis();
        mergeSort(n);
        System.out.println("정렬 시간 : " + (System.currentTimeMillis() - start) + " m/s");
        System.out.println("정렬 후 : " + Arrays.toString(n));
        //        System.out.println("정렬 후 : " + n2.toString());
    }
    
    // 기본적인 정렬 방법(인접인자를 비교하진 않음)
    public static int[] bubbleSort(int[] n)
    {
        int temp = 0;
        for (int i = 0; i < n.length; i++)
        {
            for (int j = i + 1; j < n.length; j++)
            {
                if (n[i] > n[j])
                {
                    temp = n[j];
                    n[j] = n[i];
                    n[i] = temp;
                }
                
                // 내림차순 정렬
                // if (n[i] < n[j])
                // {
                //     temp = n[j];
                //     n[j] = n[i];
                //     n[i] = temp;
                // }
            }
        }
        
        return n;
    }
    
    // 인접인자를 비교하는 버블정렬
    public static void bubbleSort2(int[] n)
    {
        boolean nSwitched;
        do
        {
            nSwitched = false;
            for (int i = 0; i < n.length - 1; i++)
            {
                if (n[i + 1] < n[i])
                {
                    int tmp = n[i + 1];
                    n[i + 1] = n[i];
                    n[i] = tmp;
                    nSwitched = true;
                }
            }
        } while (nSwitched);
    }
    
    public static void insertionSort(int[] n)
    {
        int temp = 0;
        
        for (int i = 1; i < n.length; i++)
        {
            int j;
            temp = n[i];
            for (j = i; j > 0 && n[j - 1] > temp; j--)
            {
                n[j] = n[j - 1];
            }
            n[j] = temp;
            
        }
    }
    
    public static void insertionSort2(int[] n)
    {
        // 정렬이 필요한 배열의 길이만큼 루프, 2번째 원소부터 시작하므로 i 는 1로 초기화
        for (int i = 1; i < n.length; i++)
        {
            // 루프하며 비교할 원소
            int key = n[i];
            // 비교 대상이 되는 i 보다 앞에 있는 원소의 위치
            int j = i - 1;
            // j 가 0보다 작아질 때까지 반복
            while (j >= 0)
            {
                //
                if (n[j] > key)
                {
                    n[j + 1] = n[j];
                    j--;
                }
            }
            n[j + 1] = key;
        }
    }
    
    public static void selectionSort(int[] n)
    {
        int temp = 0;
        for (int i = 0; i < n.length; i++)
        {
            int min = i;
            for (int j = n.length - 1; j > i; j--)
            {
                if (n[j] < n[min])
                    min = j;
            }
            temp = n[i];
            n[i] = n[min];
            n[min] = temp;
        }
    }
    
    // 퀵 정렬 : 리스트 형태
    public static List<Integer> quickSort(List<Integer> n)
    {
        if (n.size() < 2)
            return n;
        
        int pivot = n.get(0);
        
        List<Integer> lower = new ArrayList<Integer>();
        List<Integer> higher = new ArrayList<Integer>();
        
        for (int i = 1; i < n.size(); i++)
        {
            if (pivot > n.get(i))
                lower.add(n.get(i));
            else
                higher.add(n.get(i));
        }
        
        List<Integer> answer = quickSort(lower);
        answer.add(pivot);
        answer.addAll(quickSort(higher));
        
        return answer;
    }
    
    // 퀵 정렬 : 배열 형태
    public static void quickSort(int n[], int lower, int higher)
    {
        
        if (lower < higher)
        {
            int pivotNewIndex = partition(n, lower, higher);
            
            quickSort(n, lower, pivotNewIndex - 1);
            quickSort(n, pivotNewIndex + 1, higher);
        }
        
    }
    
    // 퀵 정렬 : 재귀호출(분할)
    public static int partition(int[] n, int lower, int higher)
    {
        
        int pivot = n[(lower + higher) / 2];
        
        while (lower < higher)
        {
            while ((n[lower] < pivot) && (lower < higher))
                lower++;
            while ((n[higher] > pivot) && (lower < higher))
                higher--;
            
            if (lower < higher)
            {
                int temp = n[lower];
                n[lower] = n[higher];
                n[higher] = temp;
            }
        }
        
        return lower;
    }
    
    // 병합 정렬
    public static void mergeSort(int[] arr)
    {
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }
    
    public static void mergeSort(int[] arr, int[] temp, int start, int end)
    {
        if (start < end)
        {
            int mid = (start + end) / 2;
            mergeSort(arr, temp, start, mid);
            mergeSort(arr, temp, mid + 1, end);
            merge(arr, temp, start, mid, end);
        }
    }
    
    public static void merge(int[] arr, int[] temp, int start, int mid, int end)
    {
        for (int i = start; i <= end; i++)
        {
            temp[i] = arr[i];
        }
        int part1 = start;
        int part2 = mid + 1;
        int index = start;
        while (part1 <= mid && part2 <= end)
        {
            if (temp[part1] <= temp[part2])
            {
                arr[index] = temp[part1];
                part1++;
            }
            else
            {
                arr[index] = temp[part2];
                part2++;
            }
            index++;
        }
        for (int i = 0; i <= mid - part1; i++)
        {
            arr[index + i] = temp[part1 + i];
        }
    }
}
