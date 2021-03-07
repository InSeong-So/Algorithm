import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort1 {

    public static void main(String[] args) {
        int[] test = {59, 2, 41, 9, 10, 1, 8, 3};
        List<Integer> test2 = new ArrayList<Integer>();
        for (Integer i : test) {
            test2.add(i);
        }

        System.out.println(Arrays.toString(mergeSort(test)));
//        System.out.println(mergeSort(test2).toString());
    }

    // 병합 정렬 알고리즘 - 배열
    public static int[] mergeSort(int[] numbers) {
        // 정렬하려는 배열의 원소가 하나라면 배열 그대로 리턴 : 재귀호출의 종료 조건
        if (numbers.length < 2) {
            return numbers;
        }

        // 분할한 원소들을 담을 배열, 0부터 절반까지(원소의 갯수가 홀수의 경우 소수점 절삭)
        int[] leftArray = Arrays.copyOfRange(numbers, 0, numbers.length / 2);
        /* 확인용
         */
        System.out.println(Arrays.toString(leftArray));

        // 분할한 원소들을 담을 배열, 절반부터 끝까지
        int[] rightArray = Arrays.copyOfRange(numbers, numbers.length / 2, numbers.length);
        /* 확인용
         */
        System.out.println(Arrays.toString(rightArray));
        // 분할한 배열을 각각 정렬하여 병합하기
        return merge(mergeSort(leftArray), mergeSort(rightArray));
    }

    // 병합
    private static int[] merge(int[] left, int[] right) {
        // 왼쪽 배열의 순서를 저장하는 포인터
        int leftPtr = 0;
        // 오른쪽 배열의 순서를 저장하는 포인터
        int rightPtr = 0;
        // 병합할 배열에 값을 저장할 위치를 나타내는 변수
        int index = 0;

        // 왼쪽 배열과 오른쪽 배열을 병합할 배열 생성
        int[] merged = new int[left.length + right.length];

        // 왼쪽 배열의 포인터가 왼쪽 배열의 크기보다 커지거나
        // 오른쪽 배열의 포인터가 오른쪽 배열의 크기보다 커지면 반복문 종료
        while (leftPtr < left.length && rightPtr < right.length) {
//            System.out.println("1번째 while문의 leftPtr : " + leftPtr);
//            System.out.println("1번째 while문의 rightPtr : " + rightPtr);
            // 왼쪽 배열의 leftPtr번째 원소 값이 오른쪽 배열의 rightPtr 원소 값보다 작다면
            if (left[leftPtr] < right[rightPtr]) {
                // 새로 만든 배열의 index번째에 값을 추가하고
                merged[index] = left[leftPtr];
                // leftPtr 증가
                leftPtr++;
                // index 증가
                index++;

                // 왼쪽 배열의 leftPtr번째 원소 값이 오른쪽 배열의 rightPtr 원소 값보다 크거나 같다면
            } else {
                // 새로 만든 배열의 index번째에 값을 추가하고
                merged[index] = right[rightPtr];
                // rightPtr 증가
                rightPtr++;
                // index 증
                index++;
            }
        }

//        System.out.println(left.length);
//        System.out.println(right.length);
//        System.out.println(leftPtr);
//        System.out.println(rightPtr);

        // 위 조건에서 검사하지 못한 요소를 재차 검사(왼쪽)
        // 왼쪽 배열의 마지막 위치에 값을 삽입하는지를 체크하는 것
        // 값이 true 라면 마지막 인덱스에 값을 삽입함
        while (leftPtr < left.length) {
            merged[index] = left[leftPtr];
            leftPtr++;
            index++;
        }

        // 위 조건에서 검사하지 못한 요소를 재차 검사(오른쪽)
        // 오른쪽 배열의 마지막 위치에 값을 삽입하는지를 체크하는 것
        // 값이 true 라면 마지막 인덱스에 값을 삽입함
        while (rightPtr < right.length) {
            merged[index] = right[rightPtr];
            rightPtr++;
            index++;
        }

        return merged;
    }

    /***************************************************************************/

    // 병합 정렬 알고리즘열 - 리스트
    public static List<Integer> mergeSort(List<Integer> values) {
        if (values.size() < 2) {
            return values;
        }

        List<Integer> leftHalf = values.subList(0, values.size() / 2);
        List<Integer> rightHalf = values.subList(values.size() / 2, values.size());
        return merge(mergeSort(leftHalf), mergeSort(rightHalf));
    }

    // 병합
    private static List<Integer> merge(List<Integer> left, List<Integer> right) {
        int leftPtr = 0;
        int rightPtr = 0;

        List<Integer> merged = new ArrayList<>(left.size() + right.size());

        while (leftPtr < left.size() && rightPtr < right.size()) {
            if (left.get(leftPtr) < right.get(rightPtr)) {
                merged.add(left.get(leftPtr));
                leftPtr++;
            } else {
                merged.add(right.get(rightPtr));
                rightPtr++;
            }
        }

        while (leftPtr < left.size()) {
            merged.add(left.get(leftPtr));
            leftPtr++;
        }

        while (rightPtr < right.size()) {
            merged.add(right.get(rightPtr));
            rightPtr++;
        }

        return merged;
    }

}
