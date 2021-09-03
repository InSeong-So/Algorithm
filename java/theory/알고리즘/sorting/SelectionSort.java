public class SelectionSort {

    public static void selectionSort(int[] numbers){
        int size = numbers.length;
        int min; //최소값을 가진 데이터의 인덱스 저장 변수
        int temp;
        
        for(int i=0; i<size-1; i++){ // size-1 : 마지막 요소는 자연스럽게 정렬됨
            min = i;
            for(int j=i+1; j<size; j++){
                if(numbers[min] > numbers[j]){
                    min = j;
                }
            }
            temp = numbers[min];
            numbers[min] = numbers[i];
            numbers[i] = temp;
        }
    }

}
